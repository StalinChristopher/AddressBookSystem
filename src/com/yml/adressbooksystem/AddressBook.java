package com.yml.adressbooksystem;
import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AddressBook {
	
	private static AddressBook instance;
	
	
	/*static AddressBook getInstance() {
	if(instance == null) {
		instance = new AddressBook();
	}
	return instance;
	}
	*/
	private List<Contact> contactList = new ArrayList<Contact>();
	
	public void addContact(Contact contact) {
		List<Contact> duplicateContactList = contactList.stream().filter(c->{
			if(c.equals(contact)){
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		if(duplicateContactList.size() == 0) {
			contactList.add(contact);
		} else {
			System.out.println("Contact already exists in the address book");
		}
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
	
	public List<Contact> getAddressBook(){
		return contactList;
	}
	
	public void deleteContact(Contact contact) {
		contactList.remove(contact);
	}
}
