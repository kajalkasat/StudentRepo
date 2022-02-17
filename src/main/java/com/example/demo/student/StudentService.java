package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// this class is for the service layer

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {

        // as we used dependency injection for the repository Interface
        return studentRepository.findAll(); // return list


//        return List.of(new Student(
//                1L,
//                "MERIAN",
//                "ck@gmail.com", LocalDate.of(2020,12,01),20));
    }

    public void addNewStudent(Student student) // when adding new studennt, the email id of the new student being added should not be already present/used
    {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(
                student.getEmail());
        if(studentOptional.isPresent())
        {
            throw new IllegalStateException("email is  used");
        }
        studentRepository.save(student);
    }

    public  void deleteStudent(Long studentid)
    {
        Boolean b = studentRepository.existsById(studentid);
        if(!b)
        {
            throw new IllegalStateException("student with id " + studentid + "doesnt exist in database");
        }
        studentRepository.deleteById(studentid);
    }

    @Transactional
    public void putmeansUpdateStudent(Long studentid, String name , String emailid) // this is a call from the student controller, hence paramter should be passed correctly
    {
        if(!studentRepository.existsById(studentid))
        {
            throw new IllegalStateException("student with id " + studentid + "doesnt exist in database");
        }
        else
        {
            Student student = studentRepository.getById(studentid);
            if(name != null && (name.length() > 0) && (!Objects.equals(name , student.getName())))
            {
                student.setName(name);
            }

            if(emailid != null && (emailid.length()>0) && (!Objects.equals(emailid , student.getEmail())))
            {
                Optional<Student> studentOptional = studentRepository.findStudentByEmail(emailid);
                if(studentOptional.isPresent())
                {
                    throw new IllegalStateException("email is  used");
                }
                student.setEmail(emailid);
            }
        }
    }

}
