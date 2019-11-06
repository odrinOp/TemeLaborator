package app.objects.services;

import app.exceptions.ValidationException;
import app.objects.Student;
import app.objects.repositories.StudentRepository;
import app.objects.validations.StudentValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceStudentsTest {


    private ServiceStudents ss;

    @BeforeEach
    void setUp() {
        StudentValidation sv = new StudentValidation();
        StudentRepository repo = new StudentRepository(sv);
        ss = new ServiceStudents(repo);

        try {
            ss.addStudent("1", "odrin", "traian", "aaa");
            ss.addStudent("2", "andrei", "ion", "caa");
            ss.addStudent("3", "ana", "andreea", "daa");
            ss.addStudent("4", "cosmin", "victor", "faa");
        }catch (ValidationException e){ }
    }

    @Test
    void addStudent() {

        try {

            assert ss.addStudent("201", "abc", "cca", "ggd") == null;
            assert ss.findStudent("201").getId().equals("201");

            Student s = ss.addStudent("1","a","a","a");
            assert s!=null;
            assert s.getId().equals("1");
            assert s.getFirstName().equals("a");

            ss.addStudent("", "", "", "");

        }catch (ValidationException e){
            assert true; }

    }

    @Test
    void removeStudent() {
        assert ss.removeStudent("1").getFirstName().equals("odrin");
        assert ss.removeStudent("1") == null;

    }

    @Test
    void updateStudent() {
        assert ss.updateStudent("1","Oprisanu","Odrin","aaa") == null;
        Student s = ss.findStudent("1");

        assert s!=null;
        assert s.getFirstName().equals("Oprisanu");
        assert s.getLastName().equals("Odrin");

        s =  ss.updateStudent("782","abc","ccc","ddd");
        assert s != null;
        assert s.getFirstName().equals("abc");




    }

    @Test
    void getAllStudents() {

        int i = 1;
        for(Student s:ss.getAllStudents())
        {
            assert s.getId().equals(String.valueOf(i));
            i++;
        }
    }

    @Test
    void findStudent() {
        assert ss.findStudent("1").getFirstName().equals("odrin");
        assert ss.findStudent("5002") == null;

    }
}