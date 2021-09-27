package com.yml.adressbooksystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.opencsv.CSVReader.*;

import com.opencsv.CSVReaderBuilder.*;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

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
		Collections.sort(contactList);
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
	
	public void saveToFile(String fileName) throws IOException {
        File file = new File("data/" + fileName + ".txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        for (Contact contact : contactList) {
            fileWriter.write(contact+"\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
	
	/**
	 * @param fileName
	 * 
	 * Method to write contacts into csv file
	 */
	public void writeCsv(String fileName) {
		File file = new File("data/"+ fileName+ "csv.csv");
		
		try {
			file.createNewFile();
			CSVWriter csvWriter = new CSVWriter(new FileWriter(file), ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
					CSVWriter.DEFAULT_LINE_END);
			String[] headerLine = {"firstName", "lastName", "address", "city", "state", "zip", "email", "phone",};
			csvWriter.writeNext(headerLine);
			for(Contact contact : contactList) {
				String[] info = {contact.getFirstName(),contact.getLastName(),contact.getAddress(),contact.getCity(),
						contact.getState(), Integer.toString(contact.getZip()), contact.getEmail(), contact.getPhone().toString()};
				csvWriter.writeNext(info);
			}
			csvWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to read contacts into csv file
	 */
	public void readCsv() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of the csv file to be read");
		String fileName = scanner.nextLine();
		File file = new File("data/"+fileName+".csv");
		if(!file.exists()) {
			System.out.println("File doesnot exist");
			return;
		}
		try {
			CSVReader reader = new CSVReader(new FileReader(file));
			List<String[]> contactsData = reader.readAll();
			for( String[] contact : contactsData) {
				for(String field : contact) {
					System.out.print(field+ ", ");
				}
				System.out.println();
			}
			reader.close();
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
	}
}
