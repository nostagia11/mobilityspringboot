package esprit.mobility.Etudiant;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Etudiant,Long> {
    Optional<Etudiant> findStudentByCin(String cin);

}
