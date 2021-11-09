package com.pharmacie.pharmacie.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacie.pharmacie.domain.entities.medecine;
import com.pharmacie.pharmacie.domain.repositories.MedecineRepository;

@Service
public class medecineService {
	
	@Autowired
	private final MedecineRepository mRepo;
	
	public medecineService(MedecineRepository mRepo){
		this.mRepo= mRepo;
	}

	public medecine getMedecine(long id){
		;
		return mRepo.getById(id);
	}
	
	public List<medecine>getMedecineAll(){
		return mRepo.findAll();
	
	}
	public void addMedecine(medecine m){
		
	 this.mRepo.save(m);
	}
	
	public void deleteMedecine(long id){
		
		mRepo.deleteById(id);
	}
	
 
}
