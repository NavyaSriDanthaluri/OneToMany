package p1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DatabaseOperation {


	public static void main(String[] args) {
		Session hibernate = HibernateConnection.getHibernateLink();

		Parent p=new Parent("Krishna","Radha",9673832310L);
		Parent gp=new Parent("Devaki","Vasudeva",9345274820L);

		Vaccination v1=new Vaccination("AB1", LocalDate.of(2020,04,11).toString(),"AB2", LocalDate.of(2020,06,10).toString(),"No issues",220);
		Vaccination v2=new Vaccination("BC1", LocalDate.of(2020,07,11).toString(),"BC2", LocalDate.of(2020,9,10).toString(),"Very good",330);
		Vaccination v3=new Vaccination("CD1", LocalDate.of(2021,03,11).toString(),"CD2", LocalDate.of(2021,05,10).toString(),"Healthy",440);
		Vaccination v4=new Vaccination("DE1", LocalDate.of(2021,06,11).toString(),"DE2", LocalDate.of(2021,07,10).toString(),"No issues",550);

		List<Vaccination> AllVaccinationCertificates = Arrays.asList(v1,v2,v3,v4);
		
		
		
		Doctors d1 = new Doctors(22, "Ramesh", "Pediatrician");
		Doctors d2 = new Doctors(33, "Rema", "Obstetrician");
		
		
		List<Doctors> allDoctors = Arrays.asList(d1,d2);

		Hospital h = new Hospital(11, "Apollo", "hos123");

		Kid k1=new Kid(LocalDate.of(2020, 11, 30).toString(),"Krishna","male",3);
		k1.setId(201);
		k1.setParentInfo(p);
		k1.setGrandParentInfo(gp);
		k1.setVaccinationCard(AllVaccinationCertificates);
		k1.setHospitalInfo(h);
		h.setAllDoctors(allDoctors);
		
		insertKid(hibernate, k1);
		//doUpdate(hibernate, 101);

	}
	public static void insertKid(Session hibernate, Kid k) {

		Transaction t1 = hibernate.beginTransaction();

		hibernate.save(k); // code to save kid data

		t1.commit();
		hibernate.close();

		System.out.println(" 5. Database commit & hibernate closed ...");
	}
	
	public static void doUpdate(Session hibernate, int id) {
		
		Transaction t1 = hibernate.beginTransaction();
		Kid kid = (Kid) hibernate.get(Kid.class,  id);
		System.out.println(kid);
		System.out.println("------------ calling some setter methods-------------------------");
		kid.setWeight(6);
		kid.setName("Krish");
		
		t1.commit();
		hibernate.close();
	}

}