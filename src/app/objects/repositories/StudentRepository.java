package app.objects.repositories;

import app.interfaces.Validator;
import app.objects.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentRepository extends AbstractRepository<String, Student> {
    public StudentRepository(Validator validator) {
        super(validator);
    }

    @Override
    public void readFromFile(String file) throws IOException {
        list.clear();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String data = reader.readLine();
        while(data!=null){

            String[] values = data.split(" ");
            if(values.length == 4)
            {
                Student s = new Student(values[0],values[1],values[2],values[3]);
                list.add(s);
            }

            data = reader.readLine();
        }

        reader.close();
    }


}
