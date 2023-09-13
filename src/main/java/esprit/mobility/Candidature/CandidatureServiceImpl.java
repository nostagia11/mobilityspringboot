package esprit.mobility.Candidature;

import esprit.mobility.Ecoles.Ecole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImpl implements CandidatureService{


    private final CandidatureRepository repository;



    @Override
    public List<Candidature> getCandidatures() {
        return repository.findAll();
    }
    /*@Override
    public List<Candidature> getCandidatures() {
        List<Candidature> listeCandidatures= repository.findAll();
        HashMap<String,Long> listeScore=new HashMap<>();

        for(Candidature cand : listeCandidatures){
            String nom=cand.getNom().concat(cand.getPrenom());
            long score=cand.getScore();
            listeScore.put(nom,score);
        }
        System.out.println(listeScore);
        Map<String, Long> listeResultat = sortByValue(listeScore);

        for (Map.Entry<String, Long> en : listeResultat.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }


        return listeResultat;

    }*/

    @Override
    public Candidature getCandidature(Long id) {
        boolean exist= repository.findById(id).isPresent();
        if (!exist){
            throw new IllegalStateException("la candidature nexiste pas");
        }
        return repository.findById(id).get();
    }

    @Override
    public void addNewCandidature(Candidature candidature) {
        Optional<Candidature> cand = repository.findCandidatureByNom(candidature.getNom());
        if(cand.isPresent()){
            throw new IllegalStateException("cette candidature existe dans la db");

        }
        else{

            int score=Integer.parseInt(candidature.getMoyenneBac())+
                    Integer.parseInt(candidature.getMoyennepremiere())+
                    Integer.parseInt(candidature.getMoyennedeuxieme())+
                    Integer.parseInt(candidature.getMoyennetroixieme())-
                    Integer.parseInt(candidature.getCredits());


            candidature.setScore((long) score);
            repository.save(candidature);
            ;
        }

    }

    @Override
    public void updateCandidatures(Long CandidatureId, Candidature Candidatureupdate) {
        Candidature cand = repository.findById(CandidatureId).orElseThrow(
                ()-> new IllegalStateException("cette cand nexiste pas"));

        if(cand.getNom()!=null&&cand.getNom().length()>0&&!Objects.equals(cand.getNom(),Candidatureupdate.getNom())){
            cand.setNom(Candidatureupdate.getNom());
        }

        if(cand.getPrenom()!=null&&cand.getPrenom().length()>0&&!Objects.equals(cand.getPrenom(),Candidatureupdate.getPrenom())){
            cand.setPrenom(Candidatureupdate.getPrenom());
        }

        if(cand.getClassecourante()!=null&&cand.getClassecourante().length()>0&&!Objects.equals(cand.getClassecourante(),Candidatureupdate.getClassecourante())){
            cand.setClassecourante(Candidatureupdate.getClassecourante());
        }
        Candidature candidatureupdated = repository.save(cand);

    }

    @Override
    public void deleteCandidatures(Long CandidatureId) {
           repository.deleteById(CandidatureId);
    }

    @Override
    public void CalculerScore(Long candidatureId){
        Candidature candidature = repository.findById(candidatureId).orElseThrow(
                ()-> new IllegalStateException("cette cand nexiste pas"));

        int score=Integer.parseInt(candidature.getMoyenneBac())+
                    Integer.parseInt(candidature.getMoyennepremiere())+
                    Integer.parseInt(candidature.getMoyennedeuxieme())+
                    Integer.parseInt(candidature.getMoyennetroixieme())-
                    Integer.parseInt(candidature.getCredits());


        candidature.setScore((long) score);
        repository.save(candidature);
    }

    @Override
    public List<Candidature> CalculResultat(String field) {
        List<Candidature> listeCandidatures= repository.findAll(Sort.by(Sort.Direction.DESC,field));
        return listeCandidatures;
    }




    public HashMap<String, Long> sortByValue(HashMap<String, Long> listeResultat){
        /*// Create a list from elements of HashMap
        List<Map.Entry<String, Long> > list =
                new LinkedList<Map.Entry<String, Long>>(listeResultat.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Long> >() {
            public int compare(Map.Entry<String, Long> o1,
                               Map.Entry<String, Long> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Long> temp = new LinkedHashMap<String, Long>();
        for (Map.Entry<String, Long> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;*/

        LinkedHashMap<String, Long> temp =
                listeResultat.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(e -> e.getKey(),
                                e -> e.getValue(),
                                (e1, e2) -> null, // or throw an exception
                                () -> new LinkedHashMap<String, Long>()));

        return temp;
    }


}
