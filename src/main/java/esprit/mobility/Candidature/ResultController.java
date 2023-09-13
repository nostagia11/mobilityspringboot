package esprit.mobility.Candidature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/resultat")
public class ResultController {
    public final  CandidatureService candidatureService;


    public ResultController(CandidatureService candidatureService){
        this.candidatureService= candidatureService;
    }

    @GetMapping(path = "/{field}")
    public List<Candidature> CalculResultat(@PathVariable String field){
        return candidatureService.CalculResultat(field);
    }
}
