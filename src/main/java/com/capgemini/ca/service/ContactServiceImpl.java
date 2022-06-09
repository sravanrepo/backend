package com.capgemini.ca.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.ca.entity.ContactBook;
import com.capgemini.ca.repo.ContactBookRepository;


//import org.springframework.beans.factory.annotation.Autowired;

//import com.casestudy.ContactApplication.repository.IContactRepository;
//import com.casestudy.ContactApplication.utils.ContactUtil;

public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactBookRepository contactRepository;

	@Override
	public Optional<ContactBook> getContact(@PathVariable long id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id);
	}

	@Override
	public List<ContactBook> getAllContacts() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	@Override
	public ContactBook addContact(@RequestBody ContactBook contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public ContactBook updateContact(@RequestBody ContactBook contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public String deleteContact(@PathVariable long id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
		return "Contact Details with ID "+id+" deleted Successfully";
	}
}
