package hotel.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private Date data_di_nascita;

    @Column
    private int numero_telefono;

    @Column
    private String email;

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
