package com.yml.adressbooksystem;
import java.util.*;
import java.math.BigInteger;
import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		
		AddressBook addressBook = AddressBook.getInstance();
		Scanner in = new Scanner(System.in);
		Contact contact = new Contact();
		while(true) {
			System.out.println("\nEnter your choice\n1.Add a new contact \n2.Display address book\n3.Edit a contact\n4.Delete a contact\n5.Exit\n");
			int choice = in.nextInt();
			switch(choice) {
			case 1:
				in.nextLine();
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
				System.out.println("Enter the email");
				String email = in.nextLine();
				contact.setEmail(email);
				System.out.println("Enter the zip code");
				int zip = in.nextInt();
				contact.setZip(zip);
				System.out.println("Enter the phone");
				BigInteger phone = in.nextBigInteger();
				contact.setPhone(phone);
				addressBook.addContact(contact);
				break;
			case 2:
				System.out.println("\nContacts:\n");
				addressBook.displayContact();
				break;
			case 3:
				editContact();
				break;
			case 4:
				deleteContact();
				break;
			case 5: 
				return;
		}
		
			
			
		}
	}

	private static void deleteContact() {
		Contact contactToDelete = null;
		Boolean found = false;
		AddressBook addressBook = AddressBook.getInstance();
		Set<Contact> contactList = addressBook.getAddressBook();
		Scanner in = new Scanner(System.in);
		System.out.println("Delete a contact");
		System.out.println("---------------");
		System.out.println("Enter the first name");
		String firstName = in.nextLine();
		System.out.println("Enter the last name");
		String lastName = in.nextLine();
		for(Contact contact : contactList) {
			if(contact.getFirstName().equals(firstName)&&contact.getLastName().equals(lastName)) {
				found = true;
				contactToDelete = contact;
				break;
			}
		}
		if(!found) {
			System.out.println("Contact not found");
			return;
		}
		addressBook.deleteContact(contactToDelete);
		System.out.println("Contact deleted");
	}

	private static void editContact() {
		Contact contactToEdit = null;
		Boolean found = false;
		AddressBook addressBook  = AddressBook.getInstance();
		Set<Contact> contactList = addressBook.getAddressBook();
		Scanner in = new Scanner(System.in);
		System.out.println("Edit a contact");
		System.out.println("----------------");
		System.out.println("Enter the first name");
		String firstName = in.nextLine();
		System.out.println("Enter the last name");
		String lastName = in.nextLine();
		for(Contact contact : contactList) {
			if(contact.getFirstName().equals(firstName)&&contact.getLastName().equals(lastName)) {
				contactToEdit = contact;
				found = true;
				break;
			}
		}
		if(!found) {
			System.out.println("Contact not found");
			return;
		}
		while(true) {
			System.out.println("Choose the parameter to edit\n1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip Code\n7.Email\n8.Phone number\n9.Exit");
			int choice = in.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the new first name");
				in.nextLine();
				String newFirstName = in.nextLine();
				contactToEdit.setFirstName(newFirstName);
				System.out.println("First name changed");
				break;
			case 2:
				System.out.println("Enter the new last name");
				in.nextLine();
				String newLastName = in.nextLine();
				contactToEdit.setLastName(newLastName);
				System.out.println("Last name changed");
				break;
			case 3:
				System.out.println("Enter the new address");
				in.nextLine();
				String newAddress = in.nextLine();
				contactToEdit.setAddress(newAddress);
				System.out.println("Address changed");
				break;
			case 4:
				System.out.println("Enter the new city");
				in.nextLine();
				String newCity = in.nextLine();
				contactToEdit.setCity(newCity);
				System.out.println("City changed");
				break;
			case 5:
				System.out.println("Enter the state");
				in.nextLine();
				String newState = in.nextLine();
				contactToEdit.setState(newState);
				System.out.println("State changed");
				break;
			case 6:
				System.out.println("Enter the Zip code");
				in.nextLine();
				int newZip = in.nextInt();
				contactToEdit.setZip(newZip);
				System.out.println("Zip changed");
				break;
			case 7:
				System.out.println("Enter the new email");
				in.nextLine();
				String newEmail = in.nextLine();
				contactToEdit.setEmail(newEmail);
				System.out.println("Email changed");
				break;
			case 8:
				System.out.println("Enter the new phone number");
				in.nextLine();
				BigInteger newPhone = in.nextBigInteger();
				contactToEdit.setPhone(newPhone);
				System.out.println("Phone number changed");
				break;
			case 9:
				return;
			}
		}
		
	}

}
