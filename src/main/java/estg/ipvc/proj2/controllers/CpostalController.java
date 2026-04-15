package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.Cpostal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class CpostalController {

    @GetMapping("/cpostal")
    public ResponseEntity<List<Cpostal>> getCpostais(){
        List<Cpostal> cpostais = new ArrayList<>();
        return ResponseEntity.ok(cpostais);
    }
}