package esprit.mobility.Offers;

import esprit.mobility.Ecoles.Ecole;
import esprit.mobility.Ecoles.EcoleRepository;
import esprit.mobility.Etudiant.Etudiant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OffersServiceImpl implements OffersService {

    private final OffersRepository offersRepository;
    private final EcoleRepository ecoleRepository;
    @Override
    public List<Offer> getOffers() {
        return offersRepository.findAll();
    }

    @Override
    public Offer getOffer(Long id) {
        boolean exist= offersRepository.findById(id).isPresent();
        if (!exist){
            throw new IllegalStateException("l'offre nexiste pas");
        }
        return offersRepository.findById(id).get();
    }

    @Override
    public void addNewOffer(Offer offer) {



            Optional<Offer> exist= offersRepository.findOfferByName(offer.getName());
            if(exist.isPresent()){
                throw new IllegalStateException("cette offre existe dans la db");
            }
            else{

                offersRepository.save(offer);
            }

        }






    @Override
    public void deleteOffer(Long offerId) {
        offersRepository.deleteById(offerId);

    }

    @Override
    public void updateOffer(Long offerId, Offer offerupdate) {
        Offer offer= offersRepository.findById(offerId).orElseThrow(
                ()->new IllegalStateException("cette offre n'existe pas")
        );
        if(offer.getName()!=null&&offer.getName().length()>0&&!Objects.equals(offer.getName(),offerupdate.getName())){
            offer.setName(offerupdate.getName());
        }
        if(offer.getDescription()!=null&&offer.getDescription().length()>0&&!Objects.equals(offer.getDescription(),offerupdate.getDescription())){
            offer.setDescription(offerupdate.getDescription());
        }

        /*if(ecole.getEmail()!=null&&ecole.getEmail().length()>0&&!Objects.equals(ecole.getEmail(),ecoleupdate.getEmail())){
            ecole.setEmail(ecoleupdate.getEmail());
        }*/
        Offer offerUpdated = offersRepository.save(offer);

    }


}
