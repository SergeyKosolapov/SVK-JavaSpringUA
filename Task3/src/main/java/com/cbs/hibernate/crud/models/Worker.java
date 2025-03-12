package com.cbs.hibernate.crud.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

//http://localhost:8080/spring_hibernate_crud_app_war_exploded/worker
@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;

    @Min(value = 18, message = "Age should be greater than 18")
    @Column(name = "age")
    private int age;

    @Column(name = "education")
    @NotEmpty(message = "Education should not be empty")
    @Size(min = 4, max = 30, message = "Education should be between 4 and 30 characters")
    private String education;

    @Column(name = "position")
    @NotEmpty(message = "Position should not be empty")
    @Size(min = 4, max = 30, message = "Position should be between 4 and 30 characters")
    private String position;

    public Worker() {

    }

    public Worker(String name, int age, String education, String position) {
        this.name = name;
        this.age = age;
        this.education = education;
        this.position = position;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    public String getEducation() { return education; }

    public void setEducation(String education) { this.education = education; }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", position='" + position +
                '}';
    }
}
