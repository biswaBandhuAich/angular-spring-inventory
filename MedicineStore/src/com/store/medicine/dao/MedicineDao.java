package com.store.medicine.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.store.medicine.bean.Medicine;

public interface MedicineDao {
	
	public void saveMedicine(Medicine m);
	public Medicine getMedicine(String id);
	public List<Medicine> getMedicine();
	public List<Medicine> getMedicineByGeneric(String generic);
	public void deleteMedicine(String id);
	void updateMedicine(String id, Medicine med);

}
