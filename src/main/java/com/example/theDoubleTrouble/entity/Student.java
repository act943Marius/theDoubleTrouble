package com.example.theDoubleTrouble.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
public class Student extends AuditModel {
    @Id
    @GeneratedValue(generator = "student_generator")
    @SequenceGenerator(
            name = "student_generator",
            sequenceName = "student_sequence",
            initialValue = 1000
    )
    private Long id;
    @NotBlank
    @Column(columnDefinition = "text")
    private String firstname;
    @NotBlank
    @Column(columnDefinition = "text")
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private com.example.theDoubleTrouble.entity.Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public com.example.theDoubleTrouble.entity.Course getCourse() {
        return course;
    }

    public void setCourse(com.example.theDoubleTrouble.entity.Course course) {
        this.course = course;
    }
}
