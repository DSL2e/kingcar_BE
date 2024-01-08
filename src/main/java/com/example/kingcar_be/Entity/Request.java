package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private long requestId;

    @NotNull
    @OneToOne
    private Member from;

    @NotNull
    @OneToOne
    private Member to;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    @Column(name = "connection")
    private boolean connection;

}
