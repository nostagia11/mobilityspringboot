package esprit.mobility.Candidature;

import esprit.mobility.Ecoles.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature,Long> {

    Optional<Candidature> findCandidatureByNom(String nom);


    @Query(value = " SELECT CONCAT(prenom,nom) AS Nom_Candidature,score FROM `candidature` " +
             "ORDER BY score DESC",nativeQuery = true)
    public List<Candidature> getReseultScore();

}
