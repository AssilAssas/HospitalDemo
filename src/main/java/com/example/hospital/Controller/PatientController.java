package com.example.hospital.Controller;


import com.example.hospital.entities.Patient;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.services.PatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
//@RequestMapping("/api/patient")

public class PatientController {

    PatientService patientService;
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0") int p ,
                        @RequestParam(name="size",defaultValue = "4") int s ,
                        @RequestParam(name="keyword",defaultValue = "") String kw

                       ){//
       Page<Patient> pagePatients = patientRepository.findByNomContains(kw,PageRequest.of(p,s));
       model.addAttribute("ListPatients",pagePatients.getContent());
       model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
       model.addAttribute("currentPage",p);
        model.addAttribute("keyword",kw);
       return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
    @GetMapping("/formPatient")
    public String formPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "formPatient";
    }
    @PostMapping("/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "formPatient";
        }
        patientRepository.save(patient);
        return "redirect:/index?keyword="+patient.getNom();
    }
    @GetMapping("/editPatient")
    public String editPatient(Model model,@RequestParam(name="id") Long id){
        Patient patient=patientRepository.findById(id).get();
        model.addAttribute("patient",patient);
        return "editPatient";
    }




}
