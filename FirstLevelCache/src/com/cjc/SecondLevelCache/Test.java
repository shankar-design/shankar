package com.cjc.SecondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		
		Student s1 = new Student();
		
		Student s2=session.get(Student.class, 101);
		System.out.println(s2.getRollno()+""+s2.getName()+""+s2.getAddress());
		
		Student s3=session.get(Student.class, 102);
		System.out.println(s3.getRollno()+""+s3.getName()+""+s3.getAddress());
		
		Session session2=sf.openSession();
		
		Student s4=session2.get(Student.class, 102);
		System.out.println(s4.getRollno()+""+s4.getName()+""+s4.getAddress());
		
	}

}
