package practice11;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

public class Teacher extends Person implements Observer {
    private List<Klass> classes = new LinkedList<>();

    public List<Klass> getClasses() {
        return classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. I teach "+ (classes.size() == 0 ? "No Class" : getClassesStr()) +".";
    }

    private String getClassesStr() {
        return "Class " + classes.stream().map(c -> String.valueOf(c.getNumber())).collect(Collectors.joining(", "));
    }

    public boolean isTeaching(Student student) {
        return classes.stream().anyMatch(c -> c.isIn(student));
    }

    public String introduceWith(Student student) {
        if (classes.contains(student.getKlass())) {
            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
        }
        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.print("I am " + super.getName() + ". " + arg + "\n");
    }
}
