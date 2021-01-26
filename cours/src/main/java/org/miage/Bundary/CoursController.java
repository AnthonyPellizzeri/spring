package org.miage.Bundary;

import org.miage.Entity.database.cours;
import org.miage.Entity.request.AddCoursRequest;
import org.miage.Entity.response.MessageResponse;
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
        CoursRessource.save(cours);

        return ResponseEntity.ok(new MessageResponse("cours registered successfully!"));
    }
}
