package com.brainacad.oop.demosocket;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private String course;
    private int id;

    public Student(String name, String course, int id) {
        this.name = name;
        this.course = course;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return course != null ? course.equals(student.course) : student.course == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
