package app;


import app.objects.*;
import app.objects.repositories.HomeworkRepository;
import app.objects.repositories.StudentRepository;
import app.objects.services.ServiceHomework;
import app.objects.services.ServiceStudents;
import app.objects.validations.HomeworkValidation;
import app.objects.validations.StudentValidation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {


        StudentValidation sv = new StudentValidation();
        StudentRepository sr = new StudentRepository(sv);
        try {
            sr.readFromFile("src/app/files/studenti.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        HomeworkValidation hv = new HomeworkValidation();
        HomeworkRepository hs = new HomeworkRepository(hv);

        ServiceStudents ss = new ServiceStudents(sr);
        YearStructure ys = new YearStructure("1");


        ServiceHomework sh = new ServiceHomework(hs,ys);

        UI ui = new UI(ss,sh);
        ui.run();





    }

}
