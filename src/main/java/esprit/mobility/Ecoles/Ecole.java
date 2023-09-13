package esprit.mobility.Ecoles;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import esprit.mobility.Offers.Offer;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ecole_id")
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "veuillez entrer le nom de l'université")
    private String name;
    @NotEmpty(message = "veuillez entrer l'emplacement de l'université")
    private String emplacement;
    @Column(unique = true)
    @NotEmpty(message = "veuillez entrer l'email de l'université")
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ecoles",fetch = FetchType.LAZY)
    /*@JoinColumn(name = "id",nullable = false)*/
    @JsonManagedReference
    private List<Offer> offres= new ArrayList<>();

}
