package com.capgemini.ca.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ca.entity.ContactBook;

@Repository
public interface ContactBookRepository extends JpaRepository<ContactBook, Long>   {

}
