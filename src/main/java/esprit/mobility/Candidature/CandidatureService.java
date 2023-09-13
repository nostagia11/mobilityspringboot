package esprit.mobility.Candidature;

import esprit.mobility.Ecoles.Ecole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public interface CandidatureService {
    public List<Candidature> getCandidatures();
    public Candidature getCandidature(Long id);

    public void addNewCandidature(Candidature Candidature) ;


    @Transactional
    public void updateCandidatures(Long CandidatureId,Candidature Candidatureupdate);


    public void deleteCandidatures(Long CandidatureId);

    public void CalculerScore(Long candidatureId);

    public List<Candidature> CalculResultat(String field);
}
