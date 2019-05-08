package com.store.medicine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.medicine.bean.Medicine;
import com.store.medicine.services.MedicineServiceImpl;

@CrossOrigin("*")
@RestController
public class MedicineController {
	@Autowired
	private MedicineServiceImpl medicineService;
	
	@GetMapping(value="/api/medicine")
	@ResponseBody
	public List<Medicine> getAllMedicines(){
		List<Medicine> medList=medicineService.getMedicine();
		return medList;
	}
	@GetMapping(value="/api/medicine/{id}")
	@ResponseBody
	public Medicine getMedicine(@PathVariable(name="id")String id){
		Medicine med=medicineService.getMedicine(id);
		return med;
	}
	
	@PostMapping(value="/api/addmedicine")
	@ResponseBody
	public String addMedicines(@RequestBody Medicine medicine){
		medicineService.saveMedicine(medicine);
		return "Succesfully Added";
	}
	
	@DeleteMapping(value="/api/deletemedicine/{id}")
	@ResponseBody
	public String addMedicines(@PathVariable(name="id") String id){
		medicineService.deleteMedicine(id);
		return "Succesfully Added";
	}
	@PutMapping(value="/api/updatemedicine/{id}")
	@ResponseBody
	public String updateMedicines(@PathVariable(name="id") String id,@RequestBody Medicine medicine){
		medicineService.updateMedicine(id, medicine);
		return "Succesfully Added";
	}
}
