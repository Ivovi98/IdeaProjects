package hotel.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import javax.persistence.*;
import java.sql.Timestamp;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recensioni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String recensione;

    @Column
    private int numero_stelle;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    @CreatedDate
    @Column
    private Timestamp data_creazione;

    @LastModifiedDate
    @Column
    private Timestamp data_ultima_modifica;

    @Version
    @Column
    private int versione;
}
