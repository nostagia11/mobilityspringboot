package esprit.mobility.Ecoles;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RequiredArgsConstructor
@Service
@Slf4j
public class EcoleServiceImpl implements EcoleService{

    private final EcoleRepository ecoleRepository;

    @Override
    public List<Ecole> getEcoles( ) {
        return ecoleRepository.findAll();
    }

    @Override
    public Ecole getEcole(Long id) {
       boolean exist= ecoleRepository.findById(id).isPresent();
       if (!exist){
           throw new IllegalStateException("lecole nexiste pas");
       }
       return  ecoleRepository.findById(id).get();
    }

    @Override
    public void addNewEcole(Ecole ecole) {
        Optional<Ecole> exist = ecoleRepository.findEcoleByName(ecole.getName());
        if(exist.isPresent()){
            throw new IllegalStateException("cette ecole existe dans la db");

        }
        else{
            ecoleRepository.save(ecole);
        }

    }

    /*@Override
    public void updateEcoles(Long ecoleId, String name, String emplacement, String email) {
        Ecole ecole = ecoleRepository.findById(ecoleId).orElseThrow(
                ()-> new IllegalStateException("cette ecole nexiste pas"));
        if(name!=null&&name.length()>0&&!Objects.equals(ecole.getName(),name)){
            ecole.setName(name);
        }

        if(emplacement!=null&&emplacement.length()>0&&!Objects.equals(ecole.getEmplacement(),emplacement)){
            ecole.setEmplacement(emplacement);
        }

        if(email!=null&&email.length()>0&&!Objects.equals(ecole.getEmail(),email)){
            ecole.setEmail(email);
        }

    }*/
    @Override
    public void updateEcoles(Long ecoleId,Ecole ecoleupdate){
        Ecole ecole = ecoleRepository.findById(ecoleId).orElseThrow(
                ()-> new IllegalStateException("cette ecole nexiste pas"));

        if(ecole.getName()!=null&&ecole.getName().length()>0&&!Objects.equals(ecole.getName(),ecoleupdate.getName())){
            ecole.setName(ecoleupdate.getName());
        }

        if(ecole.getEmplacement()!=null&&ecole.getEmplacement().length()>0&&!Objects.equals(ecole.getEmplacement(),ecoleupdate.getEmplacement())){
            ecole.setEmplacement(ecoleupdate.getEmplacement());
        }

        if(ecole.getEmail()!=null&&ecole.getEmail().length()>0&&!Objects.equals(ecole.getEmail(),ecoleupdate.getEmail())){
            ecole.setEmail(ecoleupdate.getEmail());
        }
        Ecole ecoleupdated = ecoleRepository.save(ecole);
    }



    @Override
    public void deleteEcoles(Long ecoleId) {
        ecoleRepository.deleteById(ecoleId);

    }
}
