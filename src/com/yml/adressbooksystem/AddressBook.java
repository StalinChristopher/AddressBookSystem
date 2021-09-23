package com.yml.adressbooksystem;
import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Stalin Christopher
 * Class which contains the list of contacts in a address book, each instance of this class represents a unique addressBook
 */
public class AddressBook {
	
	/*
	private static AddressBook instance;
	static AddressBook getInstance() {
	if(instance == null) {
		instance = new AddressBook();
	}
	return instance;
	}
	*/
	private List<Contact> contactList = new ArrayList<Contact>();
	
	/**
	 * @param contact
	 * Method to create a new contact add it to the contactList
	 */
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
	
	/**
	 * Method to display the contacts from the contactsList
	 */
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
	
	/**
	 * @param contact
	 * Method to delete the contact from the contactList
	 */
	public void deleteContact(Contact contact) {
		contactList.remove(contact);
	}
}
