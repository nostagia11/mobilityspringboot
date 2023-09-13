package esprit.mobility.Etudiant;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Etudiants")
public class StudentController {


    private final StudentServiceImpl studentService;


    public StudentController(StudentServiceImpl studentService){
        this.studentService = studentService;

    }



    ///REFACTOR DONT  RETURFN the enntity =>>record
    @GetMapping("{id}")
    public Etudiant getStudent(@PathVariable("id") Long id){
        return studentService.getEtudiant(id);
    }
    @GetMapping("/list")
    public List<Etudiant> getStudents(){
        return studentService.getEtudiants();
    }
    @PostMapping("/save")
    //api taking the payload and storing it to the db
    public void createStudent(@RequestBody Etudiant student){

        studentService.addNewStudent(student);
    }

    @DeleteMapping (path = "/delete/{studentId}")

    public void deleteStudent(@PathVariable( "studentId") Long student){
        studentService.deleteStudent(student);

    }
    @PutMapping(path = "/update/{studentId}")
    public void updateStudent( @PathVariable("studentId")  Long studentId,
                               @RequestParam (required = false) String name,
                               @RequestParam (required = false) double average) {
        studentService.updateStudent(studentId,name,average);



    }


}
