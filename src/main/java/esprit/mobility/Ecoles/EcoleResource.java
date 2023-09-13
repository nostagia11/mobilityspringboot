package esprit.mobility.Ecoles;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ecole")
public class EcoleResource {
    private final EcoleServiceImpl ecoleService ;

    @GetMapping("/listecole")
    @CrossOrigin(origins = "http://localhost:4200/")

    public ResponseEntity<Response> getEecoles()
    {
        return ResponseEntity.ok(Response
                .builder().timeStamp(now())
        .data(of("ecoles",ecoleService.getEcoles()))
        .message("ecoles retrieved")
        .status(OK)
        .statusCode(OK.value())
        .build()
        );
    }




}
