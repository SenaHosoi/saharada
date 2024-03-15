package jp.ac.ohara.E.seisaku.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="gakuseihyou")
public class GakuseiHyou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="studentnumber",length = 64, nullable = false)
    private String studentnumber;

    @Column(name="name",length = 128, nullable = false)
    private String name;

    @Column(name="age",length = 32, nullable = false)
    private String age;
    
    @Column(name="mail",length = 128, nullable = false)
    private String mail;

    @Column(name="phone",length = 64, nullable = true)
    private String phone;

}