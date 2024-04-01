package com.anudeep.Hibernate_MasterEmployeeMS;


import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import DepartmentDetails.Department;
import EmployeeDetails.Employee;

public class App 
{
	static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    	 Employee e=new Employee();
    	 Department d=new Department();
	        
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpUnitEMS");
  		            EntityManager em = emf.createEntityManager();
          
  		          boolean flg=true;
  		        while(flg)
  		        {
  		        	System.out.println("Enter 1 to insert Employee ");
  		        	System.out.println("Enter 2 to insert the Department");
  		        	System.out.println("Enter 3 to remove the Employee");
  		        	System.out.println("Enter 4 to remove the UPDATE Employee");
  		        	System.out.println("Enter 0 to close the program");
  		        	int num=sc.nextInt();
  		        	switch(num)
  		        	{
  		        	case  1:
  					       // Employee e=new Employee();
  					        
  					        em.getTransaction().begin();
  					      System.out.println("Enter Employee Id");
					        int id=sc.nextInt();
					        e.setId(id);
  					        //em.persist(a);
  					        System.out.println("Enter Employee name");
  					        String name=sc.next();
  					        e.setName(name);
  					        System.out.println("Enter Employee salary");
  					        double salary=sc.nextDouble();
  					       e.setSalary(salary);
  					       
  					        System.out.println(e);
  					        em.persist(e);
  					        
  					        em.getTransaction().commit();
  					        
  					        
  					        break;
  		        	case 2:
  		        		
  		        		
  		        		 em.getTransaction().begin();
 					      System.out.println("Enter Department Id");
					        int id1=sc.nextInt();
					        d.setId(id1);
 					        //em.persist(a);
 					        System.out.println("Enter Department name");
 					        String name1=sc.next();
 					        d.setName(name1);
  				        
  				        System.out.println(d);
  		        		
  		        		 em.persist(d);
  					        
  					        em.getTransaction().commit();
  					        break;
  		        	case 3:
  		        		System.out.println("Write the ID of product that you want to remove");
  		        		
  		        		int id3 = sc.nextInt() ;
  		        		e.setId(id3);
  		        		em.getTransaction().begin();
  		        		e = em.find(Employee.class, id3);
  		        		
  		        		if(e != null) {
  		        			em.remove(e);
  		        		}else {
  		        			System.out.println("Employee is not present in the database whose id is " + id3);
  		        		}
  		        		em.getTransaction().commit();
  		        		break;
  		      	case 4:
		        		System.out.println("Write the ID of product that you want to UPDATE");
		        		int id4 = sc.nextInt() ;
		        		e.setId(id4);
		        		em.getTransaction().begin();
		        		e = em.find(Employee.class, id4);
		        		
		        		if(e != null) {
		        			e.setId(id4); 
		        			System.out.print("Enter new ID: ");
		        			int newId = sc.nextInt();
		        			e.setId(newId);
		        			
		        			System.out.println("Enter new Name");
		        			String newName = sc.next();
		        			e.setName(newName);
		        			
		        			System.out.print("Enter new salary: ");
		                    double newSalary = sc.nextDouble();

		                    // Update the salary attribute of the retrieved Employee entity
		                    e.setSalary(newSalary);

		                    // Commit the transaction
		                    
		                    System.out.println("Employee salary updated successfully.");
		        		
		        		}else {
		        			System.out.println("Employee is not present in the database whose id is " + id4);
		        		}
		        		em.getTransaction().commit();
		        		break;
  		        	case 0:
  		        		
  		        		flg=false;
  		        		System.out.println("program closed");
  		        		 em.close();
  		        		break;
  		        		
  		        		
  		        	}
  		        }
  		    }
  		}
