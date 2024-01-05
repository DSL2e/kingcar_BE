package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @OneToOne(mappedBy = "article", fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;  //글쓰이

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member writer;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    private String image;

    @NotNull
    private int price;

    @NotNull
    private String contents;

    @NotNull
    private boolean connection;
}
