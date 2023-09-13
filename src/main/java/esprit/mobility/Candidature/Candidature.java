package esprit.mobility.Candidature;


import esprit.mobility.Etudiant.Section;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @AllArgsConstructor @NoArgsConstructor
public class Candidature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidature_id")
    private Long id;
    @NotEmpty(message = "veuillez entrer le nom ")
    private String nom;
    @NotEmpty(message = "veuillez entrer le prenom ")
    private String prenom;
    @NotEmpty(message = "veuillez entrer la classe")
    private String classecourante;
    @NotEmpty(message = "veuillez entrer l'option'")
    private String section;
    @NotEmpty(message = "veuillez entrer la moyenne")
    private String moyennepremiere;
    @NotEmpty(message = "veuillez entrer la moyenne")
    private String moyennedeuxieme;
    @NotEmpty(message = "veuillez entrer la moyenne")
    private String moyennetroixieme;
    @NotEmpty(message = "veuillez entrer la moyenne")
    private String moyenneBac;
    @NotEmpty(message = "veuillez entrer les credits")
    private String credits;
    @NotEmpty(message = "veuillez entrer le niv Ang")
    private String nivAng;
    @NotEmpty(message = "veuillez entrer le niv FR")
    private String nivFR;


    private Long score;

    private String Resultat;


}