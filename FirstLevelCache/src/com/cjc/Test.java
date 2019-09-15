package com.cjc;

import org.hibernate.Session;

public class Test {
	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		Student s1 = new Student();
		/*s1.setRollno(102);
		s1.setName("Prince");
		s1.setAddress("Akurdi");
		session.save(s1);	
		session.beginTransaction().commit();	*/
		
		Student s2=session.get(Student.class, 101);
		System.out.println("Rollno\tName\tAddress");
		System.out.println(s2.getRollno()+"\t"+s2.getName()+"\t"+s2.getAddress());
		
		Student s3=session.get(Student.class, 101);
		//System.out.println("Rollno\tName\tAddress");
		System.out.println(s3.getRollno()+"\t"+s3.getName()+"\t"+s3.getAddress());
		
		
		
		
		
		
	}

}
