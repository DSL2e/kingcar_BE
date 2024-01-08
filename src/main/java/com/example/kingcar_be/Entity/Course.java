package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter
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

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Article> articles;
}
