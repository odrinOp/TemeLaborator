package app.objects.validations;

import app.exceptions.ValidationException;
import app.interfaces.Validator;
import app.objects.Homework;

public class HomeworkValidation implements Validator<Homework> {
    @Override
    public void validate(Homework entity) throws ValidationException {
        String errors="";
        if(entity.getId() == null || entity.getId().equals(""))
            errors += "Invalid id\n";

        if(entity.getDescription() == null)
            errors += "Invalid description\n";

        if(!(entity.getStartWeek()>=1 && entity.getStartWeek() <= 14))
            errors+="Invalid startWeek\n";

        if(!(entity.getDeadlineWeek()>=1 && entity.getDeadlineWeek() <= 14))
            errors+="Invalid deadlineWeek\n";

        if(entity.getStartWeek() >= entity.getDeadlineWeek())
            errors += "Deadline week must be higher than start week\n";

        if(!errors.equals(""))
            throw new ValidationException(errors);

    }
}
