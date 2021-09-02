package com.yml.adressbooksystem;

import java.math.BigInteger;

public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		
		AddressBook addressBook = AddressBook.getInstance();
		
		Contact contact = new Contact();
		contact.setFirstName("abc");
		contact.setLastName("xyz");
		contact.setAddress("Surathkal");
		contact.setCity("Mangalore");
		contact.setState("Karnataka");
		contact.setPhone(new BigInteger("1234567890"));
		contact.setZip(543124);
		contact.setEmail("abcxyz@gmail.com");
		
		addressBook.addContact(contact);
		System.out.println(contact);
		
	}

}
