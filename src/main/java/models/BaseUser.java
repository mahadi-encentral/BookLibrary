package models;

import java.util.UUID;

public abstract class BaseUser {
    private String id;
    private String name;
    private String passsword;

    public BaseUser(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();

    }

    public abstract int getPriority();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s%nType: %s%n", name, this.getClass().getName());
    }

    public boolean equals(BaseUser user) {
        return user.getId().equals(id);
    }
}
