package com.application.SpringCruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.SpringCruddemo.domain.Student;
import com.application.SpringCruddemo.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
    private StudentRepository repo;
    
    public List<Student> listAll() {
        return repo.findAll();
    }
     
    public void save(Student std) {
        Student save = repo.save(std);
    }
     
    public Student get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
