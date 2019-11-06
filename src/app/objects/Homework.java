package app.objects;

import java.util.Objects;

public class Homework extends Entity<String> {
    private String description;
    private int startWeek;
    private int deadlineWeek;

    public Homework(String id, String description, int startWeek, int deadlineWeek) {
        super(id);
        this.description = description;
        this.startWeek = startWeek;
        this.deadlineWeek = deadlineWeek;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getDeadlineWeek() {
        return deadlineWeek;
    }

    public void setDeadlineWeek(int deadlineWeek) {
        this.deadlineWeek = deadlineWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Homework homework = (Homework) o;
        return getId() == homework.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),description, startWeek, deadlineWeek);
    }

    @Override
    public String toString() {
        return getId() + "/" + getDescription()+"/"+getStartWeek() + "/"+getDeadlineWeek();
    }
}



