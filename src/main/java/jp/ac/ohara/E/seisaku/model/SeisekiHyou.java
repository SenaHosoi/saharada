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
@Table(name="seisekihyou")
public class SeisekiHyou {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "japanese",length = 64, nullable = true)
    private String japanese;

    @Column(name = "math",length = 64, nullable = true)
    private String math;

    @Column(name = "science",length = 64, nullable = true)
    private String science;

    @Column(name = "society",length = 64, nullable = true)
    private String society;

    @Column(name = "english",length = 64, nullable = true)
    private String english;

}
