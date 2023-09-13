package esprit.mobility.Ecoles;

import esprit.mobility.Etudiant.Etudiant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Ecoles")

public class EcoleController {

    public final EcoleService ecoleService;

    public EcoleController(EcoleService ecoleService){
        this.ecoleService = ecoleService;
    }


    @GetMapping

    public List<Ecole> getEcoles(){
      return  ecoleService.getEcoles();

    }
    @GetMapping("{id}")
    public Ecole getStudent(@PathVariable("id") Long id){
        return ecoleService.getEcole(id);
    }

    @PostMapping("/saveecole")

    public void createEcole(@RequestBody Ecole ecole){
        ecoleService.addNewEcole(ecole);
    }
/*
    @PutMapping(path = "{ecoleId}")

        public void updateEcole(@PathVariable("ecoleId") Long ecoleId,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String emplacement,
                                @RequestParam(required = false) String email){

            ecoleService.updateEcoles(ecoleId,name,emplacement,email);
        }*/

    @PutMapping(path = "{ecoleId}")
    public void updateEcole(@PathVariable("ecoleId") Long ecoleId,
                            @RequestBody Ecole ecoleupdate){
        ecoleService.updateEcoles(ecoleId,ecoleupdate);

    }


    @DeleteMapping(path = "{ecoleId}")
    public void deleteEcole(@PathVariable("ecoleId")Long ecoleId){
        ecoleService.deleteEcoles(ecoleId);
    }


}
