package pl.pjatk.mprProject.Jacob.User;

import javax.persistence.*;
// import java.util.UUID;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surName;
    private String userName;
    private String email;
    private String password;
    private int age;

    public User(String name, String surName, String userName, String email, String password, int age) {
        this.name = name;
        this.surName = surName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", email=" + email + ", id=" + id + ", name=" + name + ", password=" + password
                + ", surName=" + surName + ", userName=" + userName + "]";
    }

}

// By using this annotation we define a identifier and map on it.
// This annotation automatically generate the primary key. If we don't specify a value, the generation type defaults to AUTO.
// private UUID id; // Id can be numerical or UUID. By using UUID we must import
// UUID from util and set types on UUID. The generation will be based on
// UUIDGenerator instead of on table or sequence generator.