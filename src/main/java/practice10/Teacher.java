package practice10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person {
    private List<Klass> classes = new LinkedList<>();

    public List<Klass> getClasses() {
        return classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }


}
