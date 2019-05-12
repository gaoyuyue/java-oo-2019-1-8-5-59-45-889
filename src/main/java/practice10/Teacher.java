package practice10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
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
        return classes.stream().anyMatch(c -> c.equals(student.getKlass()));
    }

//    public String introduceWith(Student student) {
//        if (klass.equals(student.getKlass())) {
//            return super.introduce() + " I am a Teacher. I teach " + student.getName() + ".";
//        }
//        return super.introduce() + " I am a Teacher. I don't teach " + student.getName() + ".";
//    }
}
