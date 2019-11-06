package app.objects.validations;

import app.exceptions.ValidationException;
import app.objects.Homework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkValidationTest {

    @Test
    void validate() {
        //good one
        HomeworkValidation hv = new HomeworkValidation();

        Homework hw = new Homework("1","aaa",10,11);

        try {
            hv.validate(hw);
            assert true;
        } catch (ValidationException e) {}

        hw.setId("");
        try {
            hv.validate(hw);
        } catch (ValidationException e) {
            assert e.getMessage().equals("Invalid id\n");
        }

        hw.setDescription(null);
        try {
            hv.validate(hw);
        } catch (ValidationException e) {
            //System.out.println(e.getMessage());
            assert e.getMessage().equals("Invalid id\nInvalid description\n");
        }

        hw.setStartWeek(-5);
        try {
            hv.validate(hw);
        } catch (ValidationException e) {
            assert e.getMessage().equals("Invalid id\nInvalid description\nInvalid startWeek\n");
        }

        hw.setDeadlineWeek(20);
        try {
            hv.validate(hw);
        } catch (ValidationException e) {
            assert e.getMessage().equals("Invalid id\nInvalid description\nInvalid startWeek\nInvalid deadlineWeek\n");
        }

        hw.setStartWeek(10);
        hw.setDeadlineWeek(9);
        try {
            hv.validate(hw);
        } catch (ValidationException e) {
            assert e.getMessage().equals("Invalid id\nInvalid description\nDeadline week must be higher than start week\n");
        }


    }
}