package com.example.kingcar_be.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Member {
    public Member(String nickname){
        this.nickname=nickname;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long memberId;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Article> articles;

    @NotNull
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "car_brand")
    private String carBrand;

    @Column(name = "car_model")
    private String carModel;

    @OneToOne(mappedBy = "from", fetch = FetchType.LAZY)
    @JoinColumn(name = "from")
    private Request from;

    @OneToOne(mappedBy = "to", fetch = FetchType.LAZY)
    @JoinColumn(name = "to")
    private Request to;

    public void registerBrand(String carBrand){
        this.carBrand=carBrand;
    }
}
