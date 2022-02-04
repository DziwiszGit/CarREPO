package pl.carRent.models;

import javax.persistence.*;

@Entity(name="taccount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int age;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Account() {
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account(String login, String password, String name,
                   String surname, int age, UserType userType) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.userType = userType;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public UserType getUserType() {
        return userType;
    }
}


