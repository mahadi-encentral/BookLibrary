package models;

public class Student extends  BaseUser{

    private int level;

    public Student(String name, int level) {
        super(name);
        setLevel( level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level > 5 ) level = 5;
        if(level < 1) level = 1;
        this.level = level;
    }

    public boolean isJuniorOf(Student std){
        return this.level < std.getLevel();
    }

    @Override
    public int getPriority() {
        /**
         * Students have a default priority of 7 - Student level
         * So that The MOst Senior Student would have a priority of 2
         */
        return 7 - level;
    }

    @Override
    public String toString() {
        return String.format("%sLevel: %d%n", super.toString(), level);
    }
}
