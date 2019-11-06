package app.objects;

public class Student extends Entity<String> {
    private String firstName;
    private String lastName;
    private String guidingTeacher;

    public Student(String id, String firstName, String lastName, String guidingTeacher) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.guidingTeacher = guidingTeacher;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGuidingTeacher() {
        return guidingTeacher;
    }

    public void setGuidingTeacher(String guidingTeacher) {
        this.guidingTeacher = guidingTeacher;
    }

    @Override
    public String toString(){
        return getId() + " " + firstName + " " + lastName + " " + guidingTeacher;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student st = (Student) obj;
            if(st == this)
                return true;

            if(st.getId() == this.getId())
                return true;

            if(st.getFirstName().equals(firstName) && st.getLastName().equals(lastName) && st.getGuidingTeacher().equals(guidingTeacher))
                return true;
        }
        return false;
    }
}
