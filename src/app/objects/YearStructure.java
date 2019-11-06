package app.objects;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class YearStructure extends Entity<String> {

    private SemesterStructure sem1;
    private SemesterStructure sem2;

    public YearStructure(String id){
        super(id);

        /*
        //first semester dates
        LocalDate start1 = LocalDate.of(2019,9,30);
        LocalDate end1 = LocalDate.of(2020,1,19);

        LocalDate startHoliday1 = LocalDate.of(2019,12,23);
        LocalDate endHoliday1 = LocalDate.of(2020,1,5);

        //second semester dates;
        LocalDate start2 = LocalDate.of(2020,2,24);
        LocalDate end2 = LocalDate.of(2020,6,7);

        LocalDate startHoliday2 = LocalDate.of(2020,4,20);
        LocalDate endHoliday2 = LocalDate.of(2020,4,26);


        sem1 = new SemesterStructure(start1,end1,startHoliday1,endHoliday1);
        sem2 = new SemesterStructure(start2,end2,startHoliday2,endHoliday2);

        */

    }


    public void readFromFile() throws IOException {
        String file = "src/app/files/structAnUniversitar.csv";
        BufferedReader reader = new BufferedReader(new FileReader(file));
        LocalDate[] allDates = new LocalDate[9];
        String date = "";
        date = reader.readLine();
        int i = 0;
        while(date != null){

            String[] dates = date.split("-");
            if(dates.length == 3){
                LocalDate current =  LocalDate.of(Integer.valueOf(dates[0]), Integer.valueOf(dates[1]),Integer.valueOf(dates[2]));
                allDates[i++] = current;
            }
        date = reader.readLine();
        }

        sem1 = new SemesterStructure(allDates[0],allDates[1],allDates[2],allDates[3]);
        sem2 = new SemesterStructure(allDates[4],allDates[5],allDates[6],allDates[7]);


        reader.close();

        sem1.initialize();
        sem2.initialize();

    }

    public SemesterStructure getSem1() {
        return sem1;
    }

    public void setSem1(SemesterStructure sem1) {
        this.sem1 = sem1;
    }

    public SemesterStructure getSem2() {
        return sem2;
    }

    public void setSem2(SemesterStructure sem2) {
        this.sem2 = sem2;
    }


    public int getSemesterByDate(LocalDate now){
        int current = sem1.getWeekNumber(now);
        if(current != -1)
            return 1;
        return 2;
    }


    public int getWeekByDate(LocalDate now){
        int curent = sem1.getWeekNumber(now);
        if(curent != -1)
            return curent;

        return sem2.getWeekNumber(now);
    }
}
