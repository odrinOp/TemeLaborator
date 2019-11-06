package app.objects.services;

import app.exceptions.ValidationException;
import app.objects.Homework;
import app.objects.Student;
import app.objects.YearStructure;
import app.objects.repositories.HomeworkRepository;

import java.io.IOException;
import java.time.LocalDate;

public class ServiceHomework {
    private HomeworkRepository repo;
    private YearStructure structure;

    public ServiceHomework(HomeworkRepository repo, YearStructure structure) {
        this.repo = repo;
        this.structure = structure;
    }


    /**
     *
     * @param id - the id of the homework
     * @param description - the description of the homework
     * @param deadlineWeek - the deadline week for the homework
     *
     * @return null- the homework will be saved
     *          otherwise will return the homework(id already exists)
     *
     *
     * @throws ValidationException - the homework is not valid
     */
    public Homework addHomework(String id,String description, int deadlineWeek) throws ValidationException {

        int startWeek = structure.getWeekByDate(LocalDate.now());

        Homework hw = new Homework(id,description,startWeek,deadlineWeek);
        return repo.save(hw);
    }

    /**
     *
     * @param id
     * @return null - the id doesn't exists.
     *          otherwise return the deleted homework.
     */
    public Homework deleteHomework(String id){
        return repo.delete(id);
    }

    /**
     *
     * @param id
     * @param new_description
     * @param new_deadlineWeek
     *
     * @return null - the Homework was updated
     *          otherwise return the homework( id doesn't exists)
     *
     * @throws ValidationException -- the new homework is not valid.
     */
    public Homework updateHomework(String id,String new_description, int new_deadlineWeek){
        LocalDate now = LocalDate.now();
        int startWeek = structure.getWeekByDate(now);

        Homework hw = new Homework(id,new_description,startWeek,new_deadlineWeek);
        return repo.update(hw);
    }

    /**
     *
     * @return all the homework
     */
    public Iterable<Homework> getAllHomework(){
        return repo.findAll();
    }

    /**
     *
     * @param id
     * @return null- the homework doesn't exists
     *          otherwise the homework with specific id.
     */
    public Homework findHomework(String id){
        return repo.findOne(id);
    }


    public void readFromFile() throws IOException {
        String file = "src/app/files/teme.csv";
        repo.readFromFile(file);
    }
}
