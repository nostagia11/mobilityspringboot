package esprit.mobility.Offers;


import com.fasterxml.jackson.annotation.JsonBackReference;
import esprit.mobility.Ecoles.Ecole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "veuillez entrer le nom de l'offre")
    private String name;
    @NotEmpty(message = "veuillez entrer le type de diplome")
    private String diplome;
    @NotEmpty(message = "veuillez entrer la description")
    private  String description;
    @NotEmpty(message = "veuillez entrer la condition")
    private  String cond;
    @NotEmpty(message = "veuillez entrer la durée")
    private String duree;
    private boolean mobilite;
    @NotEmpty(message = "veuillez entrer la destination")
    private String destination;
    @NotEmpty(message = "veuillez entrer les domaines")
    private String domaine;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;


    @ManyToOne
    @JoinColumn(name = "id_ecole")
    @JsonBackReference

    private Ecole ecoles;

    public Ecole getEcoles() {
        return ecoles;
    }

    public void setEcoles(Ecole ecoles) {
        this.ecoles = ecoles;
    }
}
