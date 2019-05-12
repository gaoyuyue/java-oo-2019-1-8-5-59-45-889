package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class Klass extends Observable {
    private int number;
    private Student leader;
    private List<Student> students = new ArrayList<>();

    public Student getLeader() {
        return leader;
    }

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    public boolean isIn(Student student) {
        return this.equals(student.getKlass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void assignLeader(Student leader) {
        if (!students.contains(leader)) {
            System.out.print("It is not one of us.\n");
            return;
        }
        this.leader = leader;
        setChanged();
        notifyObservers("I know " + leader.getName() + " become Leader of " + getDisplayName() + ".");
    }

    public void appendMember(Student student) {
        students.add(student);
        setChanged();
        notifyObservers("I know " + student.getName() + " has joined " + getDisplayName() + ".");
    }
}
