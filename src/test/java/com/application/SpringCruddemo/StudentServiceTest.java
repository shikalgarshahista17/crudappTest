package com.application.SpringCruddemo;


import com.application.SpringCruddemo.domain.Student;  
import com.application.SpringCruddemo.repository.StudentRepository;
import com.application.SpringCruddemo.service.StudentService;

import org.junit.jupiter.api.BeforeEach;  
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;  
import org.mockito.Mock;  
import org.mockito.MockitoAnnotations;  

import java.util.ArrayList;  
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;  

import static org.junit.jupiter.api.Assertions.*;  
import static org.mockito.Mockito.*;  

class StudentServiceTest {  

    @InjectMocks  
    private StudentService studentService;  

    @Mock  
    private StudentRepository studentRepository;  

    private Student student;  

    @BeforeEach  
    void setUp() {  
        MockitoAnnotations.openMocks(this);  
        student = new Student();  
        student.setId(1L);  
        student.setStudentname("John Doe");  
        student.setCourse("Computer Science");  
        student.setFee(5000);  
    }  

    @Test  
    void listAll() {  
        List<Student> students = new ArrayList<>();  
        students.add(student);  
        when(studentRepository.findAll()).thenReturn(students);  

        List<Student> result = studentService.listAll();  

        assertEquals(1, result.size());  
        assertEquals("John Doe", result.get(0).getStudentname());  
        verify(studentRepository, times(1)).findAll();  
    }  

    @Test  
    void save() {  
        when(studentRepository.save(student)).thenReturn(student);  

        studentService.save(student);  

        verify(studentRepository, times(1)).save(student);  
    }  

    @Test  
    void get() {  
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));  

        Student result = studentService.get(1L);  

        assertNotNull(result);  
        assertEquals("John Doe", result.getStudentname());  
        verify(studentRepository, times(1)).findById(1L);  
    }  

    @Test  
    void get_studentNotFound() {  
        when(studentRepository.findById(2L)).thenReturn(Optional.empty());  

        assertThrows(NoSuchElementException.class, () -> studentService.get(2L));  
        verify(studentRepository, times(1)).findById(2L);  
    }  

    @Test  
    void delete() {  
        doNothing().when(studentRepository).deleteById(1L);  

        studentService.delete(1L);  

        verify(studentRepository, times(1)).deleteById(1L);  
    }  
}  