package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter
public class Course {
    @Id
    @Column(name = "course_id")
    private long courseId;

}
