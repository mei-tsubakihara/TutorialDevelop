package com.techacademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email; //追加
import javax.validation.constraints.Max; //追加
import javax.validation.constraints.Min; //追加
import javax.validation.constraints.NotEmpty; //追加
import javax.validation.constraints.NotNull; //追加

import org.hibernate.validator.constraints.Length; //追加

import lombok.Data;


@Data
@Entity
@Table(name = "user")
public class User {

    /**　性別用の列挙型　*/
    public static enum Gender {
        男性, 女性
    }

    /**　主キー、自動生成　*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**　名前。20桁。null不許可　*/
    @NotEmpty //追加
    @Column(length = 20, nullable = false)
    @Length(max=20) //追加
    private String name;

    /**　性別。2桁。列挙型（文字列）　*/
    @Column(length  = 2)
    @Enumerated(EnumType.STRING)
    @NotNull //追加
    private Gender gender;

    /**　年齢 　*/
    @Min(0) //追加
    @Max(120) //追加
    private Integer age;

    /**　メールアドレス。50桁。null許可　*/
    @Column(length = 50)
    @Email //追加
    @Length(max=50) //追加
    private String email;
}
