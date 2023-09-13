package esprit.mobility.Ecoles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EcoleRepository extends JpaRepository<Ecole,Long> {


    Optional<Ecole> findEcoleByName(String name);
    List<Ecole> findEcoleByNameContains(String c);
}
