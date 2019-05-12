package practice08;

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
        return super.introduce() + " I am a Student. " + (this.equals(klass.getLeader()) ? "I am Leader of " : " I am at ") + klass.getDisplayName() + ".";
    }
}
