package com.store.medicine.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.medicine.bean.Medicine;

public interface MedicineService {
	
	public void saveMedicine(Medicine m);
	public Medicine getMedicine(String id);
	public List<Medicine> getMedicine();
	public List<Medicine> getMedicineByGeneric(String generic);
	public void deleteMedicine(String id);
	public void updateMedicine(String id);

}
