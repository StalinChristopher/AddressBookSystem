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
}
