package com.store.medicine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.store.medicine.bean.Medicine;
import com.store.medicine.dao.MedicineDao;
import com.store.medicine.dao.MedicineDaoImpl;
@Service
public class MedicineServiceImpl {

	@Autowired
	private MedicineDaoImpl medicineDao;
	
	@Transactional
	public void saveMedicine(Medicine m) {
		medicineDao.saveMedicine(m);
		
	}

	@Transactional
	public Medicine getMedicine(String id) {
		Medicine medicine=medicineDao.getMedicine(id);
		return medicine;
	}

	
	@Transactional
	public List<Medicine> getMedicine() {
		List<Medicine> medicineList=medicineDao.getMedicine();
		return medicineList;
	}

	@Transactional
	public List<Medicine> getMedicineByGeneric(String generic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void deleteMedicine(String id) {
		medicineDao.deleteMedicine(id);;		
	}

	@Transactional
	public void updateMedicine(String id,Medicine medicine) {
		medicineDao.updateMedicine(id,medicine);		
	}

}
