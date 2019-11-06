package app.objects;

import java.time.LocalDate;
import java.util.Objects;

public class Pair{
    private LocalDate startDate;
    private LocalDate endDate;

    public Pair(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
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

    public boolean contains(LocalDate currentDate){
        if(currentDate.isEqual(startDate) || currentDate.isEqual(endDate))
            return true;
        if(currentDate.isAfter(startDate) && currentDate.isBefore(endDate))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(startDate, pair.startDate) &&
                Objects.equals(endDate, pair.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}