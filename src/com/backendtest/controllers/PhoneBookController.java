package com.backendtest.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.backendtest.model.PhoneNumber;

public class PhoneBookController {
	
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

	
	public static void userInteraction() throws Exception {
		int userResponse = scanner.nextInt();
		switch (userResponse) {
		case 0:
			System.exit(0);
			break;
		case 1:
			addPhoneNumber();
			break;
		case 2:
			searchPhoneNumber();
			break;
		case 3:
			displayPhoneNumber();
			break;
		default:
			break;
		}
	}

	public static void displayPhoneNumber() {
		// TODO Auto-generated method stub
		if (phoneNumbers.size() == 0) {
			System.out.println("No Phone Number is found.");
		} else {
			for (PhoneNumber phoneNumber : phoneNumbers) {
				System.out.printf("%-10s%-30s\n", "Name:", phoneNumber.getName());
				System.out.printf("%-10s%-30s\n", "Email:", phoneNumber.getEmail());
				System.out.printf("%-10s%-30s\n\n", "Date:", phoneNumber.getDateCreated());
			}
		}
	}

	public static void searchPhoneNumber() {
		// TODO Auto-generated method stub
		System.out.println("Enter the number you want to search for: (name or email) ");
		String searchKey = scanner.next();
		for (PhoneNumber phoneNumber : phoneNumbers) {
			if (phoneNumber.getName().equalsIgnoreCase(searchKey)
					|| phoneNumber.getEmail().equalsIgnoreCase(searchKey)) {
				System.out.println(searchKey + " is found.");
				System.out.printf("%-10s%-30s\n", "Name:", phoneNumber.getName());
				System.out.printf("%-10s%-30s\n", "Email:", phoneNumber.getEmail());
				System.out.printf("%-10s%-30s\n\n", "Date:", phoneNumber.getDateCreated());
			}
		}
	}

	public static void displayMenu() {
		System.out.println("*****Phone Book*****");
		System.out.println("Please reply with the correct option:");
		System.out.println(
				"0. To quit/exit the phone book.\n1. To add a phone number\n2. To search for a number\n3. To see list of phone numbers");
	}

	public static void addPhoneNumber() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter name:");
		String name = scanner.next();
		System.out.println("Enter Email:");
		String email = scanner.next();
		if (checkForUniqueness(name, email)) {
			PhoneNumber number = new PhoneNumber(name, email, new Date());
			phoneNumbers.add(number);
			System.out.println("Phone Number added successfully.");
		} else {
			System.out.println("Phone Number already exist.");
		}
		System.out.println("Do you want to add another number? yes or no(y/n)?");
		String answer = scanner.next();
		if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
			addPhoneNumber();
		} else {
			displayMenu();
			userInteraction();
		}
	}

	public static boolean checkForUniqueness(String name, String email) {
		// TODO Auto-generated method stub
		boolean status = true;
		for (PhoneNumber phoneNumber : phoneNumbers) {
			if (phoneNumber.getName().equalsIgnoreCase(name) || phoneNumber.getEmail().equalsIgnoreCase(email)) {
				status = false;
			} else {
				status = true;
			}
		}
		return status;

	}

}
