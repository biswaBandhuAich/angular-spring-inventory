package com.store.medicine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.store.medicine.bean.Medicine;

@Repository
public class MedicineDaoImpl implements MedicineDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveMedicine(Medicine m) {
		sessionFactory.getCurrentSession().save(m);
		
	}

	@Override
	public Medicine getMedicine(String id) {
		Medicine medicine=sessionFactory.getCurrentSession().get(Medicine.class, id);
		return medicine;
		
	}

	@Override
	public List<Medicine> getMedicine() {
		List<Medicine> medicineList=sessionFactory.getCurrentSession().createQuery("from Medicine").list();
		return medicineList;
	}

	@Override
	public List<Medicine> getMedicineByGeneric(String generic) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMedicine(String id) {
		Session session=sessionFactory.getCurrentSession();
		Medicine med=session.byId(Medicine.class).load(id);
		session.delete(med);
	}

	@Override
	public void updateMedicine(String id,Medicine med) {
		Session session=sessionFactory.getCurrentSession();
		Medicine medicine=session.byId(Medicine.class).load(id);
		medicine.setBrand(med.getBrand());
		medicine.setGeneric(med.getGeneric());
		medicine.setQuantity(med.getQuantity());
		medicine.setScheduleh(med.getScheduleh());
		medicine.setTotalprice(med.getTotalprice());
		medicine.setUnitprice(med.getUnitprice());
		session.flush();
	
	}

}
