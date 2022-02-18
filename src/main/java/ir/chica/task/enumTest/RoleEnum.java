package ir.chica.task.enumTest;

public enum RoleEnum {

    ADMIN(1),NORMAL_USER(2),GUEST(3);

    private final int value;


    RoleEnum(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
