package esprit.mobility.Offers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OffersRepository extends JpaRepository<Offer, Long> {

    Optional<Offer> findOfferByName(String name);
}
