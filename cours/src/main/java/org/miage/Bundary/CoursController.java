package org.miage.Bundary;

import org.miage.Entity.cours;
import org.miage.payload.request.AddCoursRequest;
import org.miage.payload.response.MessageResponse;
import org.miage.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cours")
public class CoursController {
    @Autowired
    private org.miage.controllers.CoursRessource CoursRessource;

    @Autowired
    CoursRepository CoursRepository;

    @GetMapping()
    public ResponseEntity<List<cours>> authenticateUser() {
        List<cours> usersIterable = CoursRessource.findAll();
        return ResponseEntity.ok().body(usersIterable);
    }

    @PostMapping()
    public ResponseEntity<?> registerUser(@Valid @RequestBody AddCoursRequest AddCoursRequest) {
        // Create new cours
        cours cours  = new cours(AddCoursRequest.getName(),
                AddCoursRequest.getDescription(),
                AddCoursRequest.isFree(),
                AddCoursRequest.getPrice());
        CoursRepository.save(cours);

        return ResponseEntity.ok(new MessageResponse("cours registered successfully!"));
    }
}
