package app.objects.repositories;

import app.interfaces.Validator;
import app.objects.Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HomeworkRepository extends AbstractRepository<String, Homework> {
    public HomeworkRepository(Validator validator) {
        super(validator);
    }

    @Override
    public void readFromFile(String file) throws IOException {
        list.clear();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String data = reader.readLine();
        while(data!=null){

            String[] values = data.split("/");

            if(values.length == 4){
                Homework hw = new Homework(values[0],values[1],Integer.valueOf(values[2]),Integer.valueOf(values[3]));
                list.add(hw);
            }

            data = reader.readLine();
        }


        reader.close();
    }

}
