package esprit.mobility.Etudiant;


import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    /*private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this .studentRepository = studentRepository;
    }*/
    public List<Etudiant> getEtudiants();
    public Etudiant getEtudiant(Long id);

    public void addNewStudent(Etudiant student);

    public void deleteStudent(Long studentId);

    public void updateStudent(Long studentId, String name, double average);
}

