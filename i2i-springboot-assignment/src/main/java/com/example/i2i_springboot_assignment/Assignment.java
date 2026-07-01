package com.example.i2i_springboot_assignment;

import java.io.Serializable;

public class Assignment implements Serializable {
    private int id;
    private String title;
    private String studentName;

    // Boş constructor (Jackson'ın deserialization yapabilmesi için ŞARTTIR)
    public Assignment() {
    }

    // Parametreli constructor
    public Assignment(int id, String title, String studentName) {
        this.id = id;
        this.title = title;
        this.studentName = studentName;
    }

    // Getter ve Setter Metotları
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    // Konsola güzel yazdırabilmek için toString metodu
    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}