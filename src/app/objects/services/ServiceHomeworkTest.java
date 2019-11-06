package app.objects.services;

import app.exceptions.ValidationException;
import app.objects.Homework;
import app.objects.YearStructure;
import app.objects.repositories.HomeworkRepository;
import app.objects.validations.HomeworkValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceHomeworkTest {

    private ServiceHomework sh;
    private YearStructure yr;
    @BeforeEach
    void setUp(){
        HomeworkValidation hv = new HomeworkValidation();
        HomeworkRepository hr = new HomeworkRepository(hv);
        yr = new YearStructure("1");
        sh = new ServiceHomework(hr,yr);

        try {
            sh.addHomework("1","aaa",yr.getWeekByDate(LocalDate.now()) + 1);
            sh.addHomework("2","caa",yr.getWeekByDate(LocalDate.now()) + 2);
            sh.addHomework("3","daa",yr.getWeekByDate(LocalDate.now()) + 3);
            sh.addHomework("4","eaa",yr.getWeekByDate(LocalDate.now()) + 3);
        } catch (ValidationException e) {
            System.out.println("Refaceti testul");
        }



    }

    @Test
    void addHomework() {
        try {
            assert sh.addHomework("200","ccd",14) == null;
            Homework h = sh.findHomework("200");

            assert h!=null;
            assert h.getStartWeek() == yr.getWeekByDate(LocalDate.now());
            assert h.getDeadlineWeek() == 14;

            h = sh.addHomework("200","ccd",14);
            assert  h!=null;
            assert h.getId().equals("200");
            assert h.getDeadlineWeek() == 14;

            sh.addHomework("","",2);
        } catch (ValidationException e) {
            assert true; }


    }
    @Test
    void deleteHomework() {
        assert sh.deleteHomework("1").getDescription().equals("aaa");
        assert sh.deleteHomework("1") == null;
    }

    @Test
    void updateHomework() {
        assert sh.updateHomework("1","cca",yr.getWeekByDate(LocalDate.now())+2) == null;
        Homework h = sh.findHomework("1");
        assert h!=null;

        assert h.getStartWeek() == yr.getWeekByDate(LocalDate.now());
        assert h.getDeadlineWeek() == yr.getWeekByDate(LocalDate.now())+2;


        h = sh.updateHomework("100","ccc",14);
        assert h!=null;
        assert h.getId().equals("100");

    }

    @Test
    void getAllHomework() {

            int i = 1;
            for(Homework h:sh.getAllHomework()){
                assert h.getId().equals(String.valueOf(i));
                i++;
            }
    }

    @Test
    void findHomework() {

        assert sh.findHomework("1").getDescription().equals("aaa");
        assert sh.findHomework("10001") == null;
    }
}