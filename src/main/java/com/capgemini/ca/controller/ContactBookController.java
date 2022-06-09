package com.capgemini.ca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ca.entity.ContactBook;
import com.capgemini.ca.exception.ResourseNotFoundException;
import com.capgemini.ca.repo.ContactBookRepository;
import com.capgemini.ca.service.ContactService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")

public class ContactBookController {
	@Autowired
	private ContactBookRepository contactRepository;
	
	@GetMapping("/Contacts")
	public List<ContactBook> getAllContacts() {
		return contactRepository.findAll();
	}
	
//	@PostMapping
//	public Contact createContact(@RequestBody Contact contact) {
//		return contactRepository.save(contact);
//	}
	//Create Contact rest API
	@PostMapping("/Contacts")
	public ResponseEntity<ContactBook> createContact(@RequestBody ContactBook contact) {
		ContactBook contact1 = contactRepository.save(contact);
		return ResponseEntity.ok(contact1);
	}
	
	//get contact by id rest API
	@GetMapping("/Contacts/{id}")
	public ResponseEntity<ContactBook> getContactById(@PathVariable Long id) throws ResourseNotFoundException {
		ContactBook contact = contactRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Contact not exist with id: " +id));
		return ResponseEntity.ok(contact);
	}
	
	//update contact rest API
	@PutMapping("/Contacts/{id}")
	public ResponseEntity<ContactBook> updateContact(@PathVariable Long id, @RequestBody ContactBook contactDetails) throws ResourseNotFoundException {
		ContactBook contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Contact not exist id:" +id));
		contact.setFirstName(contactDetails.getFirstName());
		contact.setLastName(contactDetails.getLastName());
		contact.setAge(contactDetails.getAge());
		contact.setEmailId(contactDetails.getEmailId());
		contact.setGender(contactDetails.getGender());
		ContactBook updatedContact = contactRepository.save(contact);
		return ResponseEntity.ok(updatedContact);	
		
	}
	//delete contact rest API
	@DeleteMapping("/Contacts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id) throws ResourseNotFoundException {
		ContactBook contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Contact not exist id:" +id));
		contactRepository.delete(contact);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
}

