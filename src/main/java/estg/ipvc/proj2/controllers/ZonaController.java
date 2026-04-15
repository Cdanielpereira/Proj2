package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.Zona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/proj2/")

public class ZonaController {

    @GetMapping("/zona")
    public ResponseEntity<List<Zona>> getZonas(){
        List<Zona> zonas = new ArrayList<>();
        return ResponseEntity.ok(zonas);
    }
}