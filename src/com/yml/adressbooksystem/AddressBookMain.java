package com.yml.adressbooksystem;

import java.math.BigInteger;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		
		AddressBook addressBook = AddressBook.getInstance();
		Scanner in = new Scanner(System.in);
		Contact contact = new Contact();
		while(true) {
			System.out.println("Enter your choice\n 1.Add a new contact \n2.Display address book\n3.Exit\n");
			int choice = in.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the first name");
				String firstName = in.nextLine();
				contact.setFirstName(firstName);
				System.out.println("Enter the last name");
				String lastName = in.nextLine();
				contact.setLastName(lastName);
				System.out.println("Enter the address");
				String address = in.nextLine();
				contact.setAddress(address);
				System.out.println("Ente the city");
				String city = in.nextLine();
				contact.setCity(city);
				System.out.println("Enter the state");
				String state = in.nextLine();
				contact.setState(state);
				System.out.println("Enter the zip code");
				int zip = in.nextInt();
				contact.setZip(zip);
				System.out.println("Enter the phone");
				BigInteger phone = in.nextBigInteger();
				contact.setPhone(phone);
				System.out.println("Enter the email");
				String email = in.nextLine();
				contact.setEmail(email);
				addressBook.addContact(contact);
			case 2:
				addressBook.displayContact();
			case 3:
				return;
		}
		
			
			
		}
		
	}

}
