package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private long courseId;

    @NotNull
    @Column(name = "departure")
    private String departure;

    @NotNull
    @Column(name = "arrivals")
    private String arrivals;

    @OneToOne
    private Article article;
}
