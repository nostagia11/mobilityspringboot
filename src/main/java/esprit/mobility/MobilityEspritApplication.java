package esprit.mobility;

import esprit.mobility.Ecoles.Ecole;
import esprit.mobility.Ecoles.EcoleRepository;
import esprit.mobility.Etudiant.Etudiant;
import esprit.mobility.Etudiant.StudentController;
import esprit.mobility.Etudiant.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;

@SpringBootApplication
public class MobilityEspritApplication  {

    public static void main(String[] args) {
        SpringApplication.run(MobilityEspritApplication.class, args);
    }


   /* @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
       *//* Ecole E1 =  new Ecole(
                null,
                "Esprit",
                "Tunisie",
                "mobility@esprit.tn"
        );

        Ecole E2 =  new Ecole(
                null,
                "Harvard",
                "USA",
                "mobility@harvard.com"
        );
        Ecole E3 =  new Ecole(
                null,
                "Serbonne",
                "france",
                "mobility@Serbonne.tn"
        );*//*

       *//* Etudiant S1= new Etudiant(
                    null,
                    "Han",
                    "said",
                    "114528987",
                    "3A44",
                    "SAE",
                    13


            );
        Etudiant S2= new Etudiant(
                    null,
                    "sarra",
                    "said",
                    "114528124",
                    "3A46",
                    "SIM",
                    12


            );
        Etudiant S3= new Etudiant(
                    null,
                    "Han",
                    "said",
                    "114528987",
                    "3A44",
                    "SAE",
                    13


            );
        Etudiant S4= new Etudiant(
                    null,
                    "fatma",
                    "kiki",
                    "112528987",
                    "3A24",
                    "BI",
                    10


            );


        studentRepository.saveAll(List.of(S1,S2,S3,S4));*//*

    }*/


}
