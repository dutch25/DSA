package Assignment;

public class Student {
    private String id;
    private String name;
    private double mark;

    public Student(String id, String name, double mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        if (mark < 5) {
            return "Fail";
        } else if (mark < 6.5) {
            return "Average";
        } else if (mark < 7.5) {
            return "Good";
        } else if (mark < 9) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Mark: " + mark + ", Rank: " + getRank();
    }
}
