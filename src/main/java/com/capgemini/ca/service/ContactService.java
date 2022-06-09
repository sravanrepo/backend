package com.capgemini.ca.service;

import java.util.*;

import com.capgemini.ca.entity.ContactBook;

public interface ContactService {
	
	public Optional<ContactBook> getContact(long id);
	
	public List<ContactBook> getAllContacts();
	
	public ContactBook addContact(ContactBook contact);
	
	public ContactBook updateContact(ContactBook contact);
	
	public String deleteContact(long id);

}
