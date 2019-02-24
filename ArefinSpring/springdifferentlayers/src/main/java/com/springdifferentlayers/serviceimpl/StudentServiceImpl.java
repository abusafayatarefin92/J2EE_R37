package com.springdifferentlayers.serviceimpl;

import com.springdifferentlayers.dao.StudentDTO;
import com.springdifferentlayers.entity.Student;
import com.springdifferentlayers.repository.StudentRepository;
import com.springdifferentlayers.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveOrUpdate(StudentDTO studentDTO) {
        studentRepository.save(convertDTOToEntity(studentDTO));
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public Student findByEmailAddress(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<StudentDTO> findAll() {
        List<StudentDTO> dtos = new ArrayList<>();
        List<Student> list = studentRepository.findAll();
        list.forEach((std) -> {
            dtos.add(convertEntityToDTO(std));
        });
        return dtos;
    }

    @Override
    public long countNoOfStudents(String email) {
        return studentRepository.countAllByEmail(email);
    }

    public Student convertDTOToEntity(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return student;
    }

    public StudentDTO convertEntityToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }
}
