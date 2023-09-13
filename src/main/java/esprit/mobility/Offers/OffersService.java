package esprit.mobility.Offers;

import esprit.mobility.Ecoles.Ecole;
import esprit.mobility.Etudiant.Etudiant;

import java.util.List;

public interface OffersService {
    public List<Offer> getOffers();
    public Offer getOffer(Long id);

    public void addNewOffer(Offer offer);

    public void deleteOffer(Long OfferId);

    public void updateOffer(Long offerId, Offer offerupdate);
}
