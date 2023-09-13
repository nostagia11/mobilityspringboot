package esprit.mobility.Etudiant;

import jakarta.validation.Valid;
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
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;

/*
    public StudentService(StudentRepository studentRepository){
        this .studentRepository = studentRepository;
    }*/
    public Etudiant getEtudiant(Long id) {
        log.info("fetching  student by id : {} ",id);
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Etudiant> getEtudiants() {
        log.info("fetching all student");
        return studentRepository.findAll();
    }

    @Override
    public void addNewStudent(@Valid Etudiant student) {
        log.info("Saving new student: {}",student.getName());
        Optional<Etudiant> studentByCin = studentRepository
                .findStudentByCin(student.getCin());
        if(studentByCin.isPresent() && (!(studentByCin.get().getCin().length() <8))){
            throw new IllegalStateException("entrer un numero cin correcte");
        }

        studentRepository.save(student);

//        System.out.println(student);

    }

    @Override
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("student does not exist with "+ studentId);
        }
        log.info("deleting  student by ID : {}",studentId);
        studentRepository.deleteById(studentId);

    }

    @Override
    public void updateStudent(Long studentId, String name, double average) {
        Etudiant student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("student does not exist"));
        log.info("updating new student : {}",student.getName());
        if (name!= null &&
                name.length()>0&&
                !Objects.equals(student.getName(),name)) {
            student.setName(name);

        }
        if (average!= 0 &&
                average>10){
            student.setAverage(average);
        }


    }
}
