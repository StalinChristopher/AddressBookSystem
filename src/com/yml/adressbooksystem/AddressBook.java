package com.yml.adressbooksystem;

import java.util.HashSet;
import java.util.Set;

public class AddressBook {
	
	private static AddressBook instance;
	
	private AddressBook() {
		
	}
	
	static AddressBook getInstance() {
		if(instance == null) {
			instance = new AddressBook();
		}
		return instance;
	}
	
	private Set<Contact> contactList = new HashSet<Contact>();
	
	public void addContact(Contact contact) {
		contactList.add(contact);
	}
	
	public void displayContact() {
		if(contactList.size() == 0) {
			System.out.println("No contacts in the address book");
			return;
		}
		for(Contact contact : contactList) {
			System.out.println(contact);
		}
	}
	
	public Set<Contact> getAddressBook(){
		return contactList;
	}
	
	public void deleteContact(Contact contact) {
		contactList.remove(contact);
	}
}
