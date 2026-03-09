package entity;

public enum RoleType {
    USER("Обычный пользователь"),
    ADMINISTRATOR("Администратор");

    private String displayName;

    RoleType(String displayName) {
        this.displayName = displayName;
    }

    public String displayName(){
        return displayName;
    }
}