package pl.carRent.models;

public enum UserType {
    DEFAULT("DEFAULT"),
    MANAGER("MANAGER"),
    ADMIN("ADMIN");
    String type;
    UserType(String type){this.type=type;}
}
