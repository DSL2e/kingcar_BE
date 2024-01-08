package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Request {
    public Request(Member from, Member to, Article article, boolean connection){
        this.from=from;
        this.to=to;
        this.article=article;
        this.connection=connection;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fromList_memberId")
    private Member from;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "toList_memberId")
    private Member to;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @NotNull
    @Column(name = "connection")
    private boolean connection;

    public void registerWinner(){
        this.connection=true;
    }

}
