package models;

public class Staff extends BaseUser{

    public Staff(String name) {
        super(name);
    }

    /**
     * Staffs Have A default priority of 1 (highest)
     */
    @Override
    public int getPriority() {
        return 1;
    }
}
