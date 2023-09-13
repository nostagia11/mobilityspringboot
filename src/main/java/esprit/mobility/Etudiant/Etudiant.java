package esprit.mobility.Etudiant;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "veuillez entrer le nom de l'etudiant")
    private String name;
    @NotEmpty(message = "veuillez entrer le prenom de l'etudiant")
    private String surname;
    @Column(unique = true)
    @NotEmpty(message = "veuillez entrer le cin de l'etudiant")
    private String cin;
    @NotEmpty(message = "veuillez entrer le classe de l'etudiant")
    private String classe;
    @NotEmpty(message = "veuillez selectionner la Section de l'etudiant")
    private String section;
    @NotNull(message = "veuillez entrer le moyenne de l'etudiant")
    private double average;


}
