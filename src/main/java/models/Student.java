package models;

public class Student extends  BaseUser{

    private int level;

    public Student(String name, int level) {
        super(name);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isJuniorOf(Student std){
        return this.level < std.getLevel();
    }

}
