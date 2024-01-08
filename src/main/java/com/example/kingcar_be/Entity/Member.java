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
@Setter
public class Member {
    public Member(String nickname){
        this.nickname=nickname;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long memberId;

    @Getter
    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Article> articles;

    @NotNull
    @Column(name = "nickname")
    private String nickname;

    @Column(name = "car_brand")
    private String carBrand;

    @Column(name = "car_model")
    private String carModel;

    @OneToMany(mappedBy = "from", fetch = FetchType.LAZY)
    private List<Request> fromList;

    @OneToMany(mappedBy = "to", fetch = FetchType.LAZY)
    private List<Request> toList;

    public void registerBrand(String carBrand){
        this.carBrand=carBrand;
    }
    public void registerModel(String carModel){
        this.carModel=carModel;
    }


}
