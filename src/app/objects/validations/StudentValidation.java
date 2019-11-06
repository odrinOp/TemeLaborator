package app.objects.validations;

import app.exceptions.ValidationException;
import app.interfaces.Validator;
import app.objects.Student;

public class StudentValidation implements Validator<Student> {
    @Override
    public void validate(Student entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId().equals(""))
            errors += "Invalid ID!\n";

        if(entity.getFirstName() == null ||  entity.getFirstName().equals("") )
            errors += "Invalid first name!\n";

        if(entity.getLastName() == null || entity.getLastName().equals("") )
            errors += "Invalid last name!\n";

        if(entity.getGuidingTeacher() == null || entity.getGuidingTeacher().equals("") )
            errors += "Invalid guiding teacher's name!\n";

        if(!errors.equals(""))
            throw new ValidationException(errors);
    }
}
