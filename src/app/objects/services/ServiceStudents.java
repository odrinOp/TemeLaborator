package app.objects.services;

import app.exceptions.ValidationException;
import app.objects.Student;
import app.objects.repositories.StudentRepository;

import java.io.IOException;
import java.util.Iterator;

public class ServiceStudents {
    private StudentRepository repo;

    public ServiceStudents(StudentRepository repo) {
        this.repo = repo;
    }


    /**
     * @param id - The id of the student
     * @param firstName - The first name of the student
     * @param lastName - The last name of the student
     * @param guidingTeacher - The name of the guidingTeacher
     * @return null- if the student is saved in repository
     *       student- if the student is already saved in repository
     *
     * @throws ValidationException- if the student is not valid
     */
    public Student addStudent(String id, String firstName,String lastName,String guidingTeacher) throws ValidationException {
        Student student = new Student(id,firstName,lastName,guidingTeacher);
        return repo.save(student);
    }


    /**
     *
     * @param id- the ID of the student.
     * @return null - if the student with specific id is not found
     *       student - the student with the specific id
     */
    public Student removeStudent(String id){
        return repo.delete(id);
    }


    /**
     *
     * @param id
     * @param new_firstName
     * @param new_lastName
     * @param new_guidingTeacher
     * @return null - if the student data is updated.
     *      student - if the student doesn't exists.
     */
    public Student updateStudent(String id, String new_firstName, String new_lastName, String new_guidingTeacher){
        Student student = new Student(id,new_firstName,new_lastName,new_guidingTeacher);
        return repo.update(student);
    }

    /**
     *
     * @return - a list of students
     */
    public Iterable<Student> getAllStudents(){
        return repo.findAll();
    }

    /**
     * @param id
     * @return null - the student with specific id doesn't exists
     *    student- with the specific id.
     */
    public Student findStudent(String id){
        return repo.findOne(id);
    }


    public void readFromFile() throws IOException {
        String file = "src/app/files/studenti.csv";
        repo.readFromFile(file);
    }




}
