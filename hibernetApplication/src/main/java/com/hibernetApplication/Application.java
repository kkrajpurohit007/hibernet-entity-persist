package com.hibernetApplication;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernetApplication.entities.Employee;
import com.hibernetApplication.utility.HibernateUtil;

public class Application {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	session.beginTransaction();
	    	/*
	    	 persist() -> This method is used to save an entity object into database and return a void.
	    	 *if an entity already exists in the database the It will throw an exception 
	    	 */
	    	  session.persist(getEmployee1());
	    	/*
	    	 save() -> This method is used to save an entity object into database and return generated primary key.
	    	  If an entity already exists in the database  then It will throw an exception.
	    	 */
	    	Integer id =(Integer)session.save(getEmployee2());
	    	System.out.println("Employee is created  with Id::"+id);
	    	
	    	//saveOrUpdate()->This method is basically used to either save or update an entity in the database.
	    	session.saveOrUpdate(getEmployee3());
	    	
	    	session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	private static Employee getEmployee3(){
		Employee employee= new Employee();
		employee.setEmployeeName("Martin Bingel");
		employee.setEmail("martin.cs2017@gmail.com");
		employee.setSalary(80000.00);
		employee.setDoj(new Date());
		return employee;
	}
	
	private static Employee getEmployee1(){
		Employee employee= new Employee();
		employee.setEmployeeName("Frank Bingel");
		employee.setEmail("frank.cs2017@gmail.com");
		employee.setSalary(30000.00);
		employee.setDoj(new Date());
		return employee;
	}
	
	private static Employee getEmployee2(){
		Employee employee= new Employee();
		employee.setEmployeeName("Sean Bingel");
		employee.setEmail("sean.cs2017@gmail.com");
		employee.setSalary(60000.00);
		employee.setDoj(new Date());
		return employee;
	}

}
