package com.yml.adressbooksystem;
import java.util.*;
import java.math.BigInteger;
import java.util.Scanner;

public class AddressBookMain {
	static Scanner in = new Scanner(System.in);
	static Map<String,AddressBook> addressBookMap = new HashMap<String,AddressBook>();
	static AddressBook addressBook = null;
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		selectAddressBook();
		while(true) {
			System.out.println("\nEnter your choice\n1.Add a new contact \n2.Display address book\n3.Edit a contact\n4.Delete a contact\n5.Choose a different addressbook\n6.Exit\n");
			int choice = in.nextInt();
			in.nextLine();
			switch(choice) {
			case 1:
				createContact();
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
				selectAddressBook();
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice");
				break;
			}
		}
	}
	
	private static void selectAddressBook() {
		System.out.println("Select the addressbook\nEnter your choice\n1.Add a new addressbook \n2.Choose an existing addressbook");
		int choice = in.nextInt();
		in.nextLine();
		if(choice == 1) {
			System.out.println("Enter a name for your addressbook");
			String name = in.nextLine();
			if(addressBookMap.get(name) != null) {
				System.out.println("Addressbook with the same name exists ");
				return;
			}
			AddressBook newAddressBook = new AddressBook();
			addressBookMap.put(name,newAddressBook);
			addressBook = addressBookMap.get(name);
			System.out.println("Address book "+name+" has been created and is set as the current addressbook");
		}
		else if(choice == 2) {
			if(addressBookMap.size() == 0) {
				System.out.println("\nNo addressbook is present. Please create a new addressbook\n");
				selectAddressBook();
				return;
			}
			int count =1;
			for(String addressBookName : addressBookMap.keySet()) {
				System.out.println((count++)+". "+addressBookName);
			}
			System.out.println("Enter the name of desired addressbook ");
			String addressBookName = in.nextLine();
			addressBook = addressBookMap.get(addressBookName);
		}
	}

	private static void createContact() {
		Contact contact = new Contact();
		System.out.println("Enter the first name");
		String firstName = in.nextLine();
		System.out.println("Enter the last name");
		String lastName = in.nextLine();
		List<Contact> contactList = addressBook.getAddressBook();
		for(Contact item : contactList) {
			if(item.getFirstName().equals(firstName)&&item.getLastName().equals(lastName)) {
				System.out.println("\nContact with same name already exists");
				return;
			}
		}
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		System.out.println("Enter the address");
		String address = in.nextLine();
		contact.setAddress(address);
		System.out.println("Enter the city");
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
		
	}

	private static void deleteContact() {
		Contact contactToDelete = null;
		Boolean found = false;
		List<Contact> contactList = addressBook.getAddressBook();
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
		List<Contact> contactList = addressBook.getAddressBook();
		System.out.println("Edit a contact");
		System.out.println("----------------");
		System.out.println("Enter the first name");
		in.nextLine();
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
	
	/* Already added logic to add multiple contacts in the address book */

}
