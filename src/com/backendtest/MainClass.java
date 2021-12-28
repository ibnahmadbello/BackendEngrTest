package com.backendtest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.backendtest.model.PhoneNumber;

public class MainClass {

	private static Scanner scanner;
	private static ArrayList<PhoneNumber> phoneNumbers;
	
	
	
	public static void main(String[] args) throws Exception {
		scanner = new Scanner(System.in);
		phoneNumbers = new ArrayList<PhoneNumber>();
		System.out.println("*****Phone Book*****");
		System.out.println("Please reply with the correct option:");
		System.out.println("1. To add a phone number\n2. To search for a number\n3. To see list of phone numbers");
		
		int userResponse = scanner.nextInt();
		switch (userResponse) {
		case 1:
			addNumber();
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
		
		
//		PhoneNumber $080 = new PhoneNumber("Jame", "abc", new Date());
//		numbers.add($080);
//		
//		PhoneNumber $090 = new PhoneNumber("Smith", "xyz", new Date());
//		numbers.add($090);
//		
//		for (PhoneNumber phoneNumber : numbers) {
//			System.out.print(phoneNumber.getName() + " " + phoneNumber.getEmail() + " " + phoneNumber.getDateCreated());
//			System.out.println();
//		}
	}

	private static void addNumber() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter Email:");
		String email = scanner.next();
		PhoneNumber number = new PhoneNumber(name, email, new Date());
		phoneNumbers.add(number);
		System.out.println("Phone Number added successfully.");
	}

}
