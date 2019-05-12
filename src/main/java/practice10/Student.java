package practice10;

import java.util.Objects;

public class Student extends Person {
    private Klass klass;
    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Student. " + (this.equals(klass.getLeader()) ? "I am Leader of " : "I am at ") + klass.getDisplayName() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(klass, student.klass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), klass);
    }
}
