package com.coforge;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coforge.config.Appconfig;
import com.coforge.dao.EmployeeDao;
import com.coforge.entities.Employee;

import java.util.List;
import java.util.Scanner;
 
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		EmployeeDao dao = context.getBean(EmployeeDao.class);
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.println("\n===== Employee Menu =====");
			System.out.println("1. Insert Employee");
			System.out.println("2. Get Employee by ID");
			System.out.println("3. Get All Employees");
			System.out.println("4. Update Employee");
			System.out.println("7.  update only salary");
			System.out.println("5. Delete Employee");
			System.out.println("6. Exit");
			System.out.print("choice: ");
			String choice = sc.nextLine().trim();
			switch (choice) {
			case "1":
				try {
					System.out.print("Enter id: ");
					long id = Long.parseLong(sc.nextLine().trim());
					System.out.print("Enter name: ");
					String name = sc.nextLine().trim();
					System.out.print("Enter salary: ");
					double salary = Double.parseDouble(sc.nextLine().trim());
					Employee emp = new Employee(id, name, salary);
					dao.insertEmployee(emp);
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid number entered. Operation cancelled.");
				}
				break;
			case "2":
				try {
					System.out.print("Enter id: ");
					long id = Long.parseLong(sc.nextLine().trim());
					Employee e = dao.getEmployeeById(id);
					if (e != null) {
						System.out.println(e);
					} else {
						System.out.println("Employee not found for id: " + id);
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid id.");
				}
				break;
			case "3":
				List<Employee> list = dao.getAllEmployees();
				if (list == null || list.isEmpty()) {
					System.out.println("No employees found.");
				} else {
					list.forEach(System.out::println);
				}
				break;
			case "4":
				try {
					System.out.print("Enter id of employee to update: ");
					long id = Long.parseLong(sc.nextLine().trim());
					Employee existing = dao.getEmployeeById(id);
					if (existing == null) {
						System.out.println("No employee found with id: " + id);
						break;
					}
					System.out.print("Enter new name (leave blank to keep '" + existing.getEname() + "'): ");
					String name = sc.nextLine().trim();
					if (!name.isEmpty()) existing.setEname(name);
					System.out.print("Enter new salary (leave blank to keep '" + existing.getSalary() + "'): ");
					String salInput = sc.nextLine().trim();
					if (!salInput.isEmpty()) {
						double salary = Double.parseDouble(salInput);
						existing.setSalary(salary);
					}
					dao.updateEmployee(existing);
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid number entered. Update cancelled.");
				}
				break;
			case "5":
				try {
					System.out.print("Enter id to delete: ");
					long id = Long.parseLong(sc.nextLine().trim());
					dao.deleteEmployee(id);
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid id.");
				}
				break;
			case "6":
				running = false;
			case "7":
				System.out.print("Enter id of employee to update: and slaary ");
				long id = Long.parseLong(sc.nextLine().trim());
				com.coforge.entities.Employee existing = dao.getEmployeeById(id);
				if (existing == null) {
					System.out.println("No employee found with id: " + id);
					break;}
					System.out.print("Enter new name (leave blank to keep '" + existing.getEname() + "'): ");
					String name = sc.nextLine().trim();
					if (!name.isEmpty()) existing.setEname(name);
					System.out.print("Enter new salary (leave blank to keep '" + existing.getSalary() + "'): ");
					String salInput = sc.nextLine().trim();
					if (!salInput.isEmpty()) {
						double salary = Double.parseDouble(salInput);
						existing.setSalary(salary);
					}
					dao.updateEmployee(existing);
				
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
		System.out.println("Exiting application...");
		sc.close();
		context.close();
	}
 
}