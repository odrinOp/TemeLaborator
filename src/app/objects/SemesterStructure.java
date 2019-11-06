package app.objects;

import java.time.LocalDate;
import java.util.LinkedList;

public class SemesterStructure {

    private LinkedList<Pair> weekDates;


    private LocalDate startDate;
    private LocalDate endDate;

    private LocalDate startHoliday;
    private LocalDate endHoliday;


    public SemesterStructure(LocalDate startDate, LocalDate endDate,LocalDate startHoliday,LocalDate endHoliday) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startHoliday = startHoliday;
        this.endHoliday = endHoliday;


        weekDates = new LinkedList<>();
    }

    public void initialize(){
        weekDates.clear();

        LocalDate date = startDate;
        while(date.isBefore(endDate) || date.isEqual(endDate)){

            if(date.isAfter(endHoliday) || date.isBefore(startHoliday)){
                Pair p = new Pair(date,date.plusDays(6));

                weekDates.add(p);
            }

            date = date.plusDays(7);

        }

    }

    public int getWeekNumber(LocalDate date){
        int i = 1;
        for(Pair p:weekDates)
        {
            if(p.contains(date))
                return i;
            i+=1;
        }
        return -1;
    }

    public LinkedList<Pair> getWeekDates() {
        return weekDates;
    }

    public void setWeekDates(LinkedList<Pair> weekDates) {
        this.weekDates = weekDates;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartHoliday() {
        return startHoliday;
    }

    public void setStartHoliday(LocalDate startHoliday) {
        this.startHoliday = startHoliday;
    }

    public LocalDate getEndHoliday() {
        return endHoliday;
    }

    public void setEndHoliday(LocalDate endHoliday) {
        this.endHoliday = endHoliday;
    }
}




