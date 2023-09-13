package esprit.mobility.Candidature;


import esprit.mobility.Ecoles.Ecole;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/candidatures")
public class CandidatureController {
    public final  CandidatureService candidatureService;


    public CandidatureController(CandidatureService candidatureService){
        this.candidatureService= candidatureService;
    }


    @GetMapping

    public List<Candidature> getCandidatures(){
        return  candidatureService.getCandidatures();

    }
    @GetMapping("{id}")
    public Candidature getCandidature(@PathVariable("id") Long id){
        return candidatureService.getCandidature(id);
    }

    @PostMapping("/saveCandidature")

    public void createCandidature(@RequestBody Candidature Candidature){
        candidatureService.addNewCandidature(Candidature);
    }


    @PutMapping(path = "{CandidatureId}")
    public void updateCandidature(@PathVariable("CandidatureId") Long CandidatureId,
                            @RequestBody Candidature Candidatureupdate){
        candidatureService.updateCandidatures(CandidatureId,Candidatureupdate);

    }


    @DeleteMapping(path = "{CandidatureId}")
    public void deleteCandidature(@PathVariable("CandidatureId")Long CandidatureId){
        candidatureService.deleteCandidatures(CandidatureId);

    }

    @PutMapping(path = "/score/{CandidatureId}")

    public void CalculScore(@PathVariable("CandidatureId")Long  candidatureId){
          candidatureService.CalculerScore(candidatureId);

    }





}
