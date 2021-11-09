package com.pharmacie.pharmacie.domain.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacie.pharmacie.domain.entities.medecine;
import com.pharmacie.pharmacie.domain.services.medecineService;




@Controller
@RequestMapping("/medicine")
public class medecineController {

	@Autowired
	private final medecineService mService;
	
	public medecineController(medecineService mService){
		this.mService = mService;
	}
	@GetMapping("/showAll")
	public String showAll(Model model){
		model.addAttribute("medicines",mService.getMedecineAll());
		for (medecine medecine : mService.getMedecineAll()) {
			System.out.println("$$$$$$$"+medecine.getName()+"$$$$$$$");
		}
		return "backend/medicines";
	}
	@GetMapping("/addMedicine")
	public String addMedicine(Model model){
		medecine medecine = new medecine();
		model.addAttribute("medecine",medecine);
		return "backend/addMedicine";
	}
	
	@GetMapping("/list")
	public String show(Model model){
		model.addAttribute("medicines",mService.getMedecineAll());
		for (medecine medecine : mService.getMedecineAll()) {
			System.out.println("$$$$$$$"+medecine.getName()+"$$$$$$$");
		}
		return "frontend/med";
	}
	
	
	@PostMapping("/addMedicine")
	public void registerMedecine(@RequestBody medecine m){
		mService.addMedecine(m);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteMedecine(@PathVariable("id") long id){
		mService.deleteMedecine(id);
	}
	}

