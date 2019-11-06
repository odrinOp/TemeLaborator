package app.objects;

import app.exceptions.ValidationException;
import app.objects.services.ServiceHomework;
import app.objects.services.ServiceStudents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class UI {
    private ServiceStudents ss;
    private ServiceHomework sh;


    public UI(ServiceStudents ss, ServiceHomework sh) {
        this.ss = ss;
        this.sh = sh;
    }

    private void mainMenu(){
        System.out.println("1.Students");
        System.out.println("2.Homework");


        System.out.println("0. Exit");
    }


    private void studentMenu(){
        System.out.println("1.Add Student");
        System.out.println("2.Delete Student");
        System.out.println("3.Update Student");
        System.out.println("4.Find Student by ID");
        System.out.println("5.Show all students");
        System.out.println("0.Back");
    }


    private void homeworkMenu(){
        System.out.println("1.Add Homework");
        System.out.println("2.Delete Homework");
        System.out.println("3.Update Homework");
        System.out.println("4.Find Homework by ID");
        System.out.println("5.Show all homework");
        System.out.println("0.Back");
    }

    private void uiAddStudent() throws ValidationException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();
        System.out.println("Enter the first name");
        String firstName = sc.nextLine();
        System.out.println("Enter the last name");
        String lastName = sc.nextLine();
        System.out.println("Enter the guiding teacher name");
        String guidingTeacher = sc.nextLine();


        Student s = ss.addStudent(id,firstName,lastName,guidingTeacher);
        if(s == null)
            System.out.println("Student added!");
        else
            System.out.println("Id already used!");

    }


    private void uiDeleteStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();

        Student s = ss.removeStudent(id);
        if(s == null)
            System.out.println("ID doesn't exists!");

        else
            System.out.println("Student : " + s + "deleted!");
    }

    private void uiFindStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();

        Student s = ss.findStudent(id);
        if(s == null)
            System.out.println("The ID doesn't exists!");

        else
            System.out.println(s);
    }


    private void uiUpdateStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();
        System.out.println("Enter the new first name");
        String firstName = sc.nextLine();
        System.out.println("Enter the new last name");
        String lastName = sc.nextLine();
        System.out.println("Enter the new guiding teacher name");
        String guidingTeacher = sc.nextLine();

        Student s = ss.updateStudent(id,firstName,lastName,guidingTeacher);
        if(s == null)
            System.out.println("Updated student");
        else
            System.out.println("ID doesn't exists!");
    }


    private void uiPrintAllStudents(){
        for(Student s:ss.getAllStudents())
            System.out.println(s);
    }



    private void uiAddHomework() throws ValidationException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();
        System.out.println("Enter the description");
        String description = sc.nextLine();
        System.out.println("Enter the deadline week");
        int deadlineWeek = sc.nextInt();

        Homework h = sh.addHomework(id,description,deadlineWeek);
        if(h==null)
            System.out.println("Homework added");
        else
            System.out.println("ID already exists");
    }

    private void uiDeleteHomework(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();

        Homework h = sh.deleteHomework(id);
        if(h!=null)
            System.out.println("Homework: "+ h + " added");
        else
            System.out.println("ID doesn't exists");
    }

    private void uiUpdateHomework(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();
        System.out.println("Enter the new description");
        String description = sc.nextLine();
        System.out.println("Enter the new deadline week");
        int deadlineWeek = sc.nextInt();

        Homework h =sh.updateHomework(id,description,deadlineWeek);
        if(h==null)
            System.out.println("Homework updated");
        else
            System.out.println("ID doesn't exists");
    }

    private void uiFindHomework(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id");
        String id = sc.nextLine();

        Homework h = sh.findHomework(id);
        if(h==null)
            System.out.println("Homework doesn't exists");
        else
            System.out.println(h);
    }

    private void readFromFile() throws IOException {
        ss.readFromFile();
        sh.readFromFile();
    }
    private void uiPrintHomework(){
        for(Homework homework: sh.getAllHomework())
            System.out.println(homework);
    }

    public void run(){
            Scanner sc = new Scanner(System.in);
            String cmd = "";
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
                try {
                    mainMenu();
                    System.out.println(">>");
                    cmd = sc.next();
                    if (cmd.equals("0"))
                        return;

                    if (!(cmd.equals("2") || cmd.equals("1")))
                        System.out.println("Invalid command!");
                    if (cmd.equals("1")) {
                        studentMenu();
                        Scanner sc1 = new Scanner(System.in);
                        String cmd1 = sc1.next();
                        switch (cmd1) {
                            case "1":
                                uiAddStudent();
                                break;
                            case "2":
                                uiDeleteStudent();
                                break;
                            case "3":
                                uiUpdateStudent();
                                break;
                            case "4":
                                uiFindStudent();
                                break;
                            case "5":
                                uiPrintAllStudents();
                                break;
                            default:
                                System.out.println("Invalid command");
                                break;
                        }

                    }
                    if (cmd.equals("2")) {
                        homeworkMenu();
                        Scanner sc1 = new Scanner(System.in);
                        String cmd1 = sc1.next();
                        switch (cmd1) {
                            case "1":
                                uiAddHomework();
                                break;
                            case "2":
                                uiDeleteHomework();
                                break;
                            case "3":
                                uiUpdateHomework();
                                break;
                            case "4":
                                uiFindHomework();
                                break;
                            case "5":
                                uiPrintHomework();
                                break;
                            default:
                                System.out.println("Invalid command");
                                break;
                        }
                    }


                }catch (ValidationException e){
                    e.printStackTrace();
                }
            }

    }
}
