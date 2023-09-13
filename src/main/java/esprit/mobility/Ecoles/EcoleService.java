package esprit.mobility.Ecoles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public interface EcoleService {


   /* private final EcoleRepository ecoleRepository;

    @Autowired
   public  EcoleService(EcoleRepository ecoleRepository){

       this.ecoleRepository = ecoleRepository;
   }*/

    public List<Ecole> getEcoles();
    public Ecole getEcole(Long id);

    public void addNewEcole(Ecole ecole) ;


    @Transactional
    public void updateEcoles(Long ecoleId,Ecole ecoleupdate);


    public void deleteEcoles(Long ecoleId);
}
