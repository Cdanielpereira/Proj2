package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.model.Catering;
import estg.ipvc.proj2.repository.CateringRepository;
import estg.ipvc.proj2.services.CateringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/proj2/")

public class CateringController {

    private CateringService cateringService;

    @Autowired
     public CateringController(CateringService cateringService) {
        this.cateringService = cateringService;
    }

    @GetMapping("/catering")
    public ResponseEntity<List<Catering>> getCaterings(){
        List<Catering> caterings = new ArrayList<>();
        return ResponseEntity.ok(caterings);
    };

    @GetMapping("catering/{id}")
    public Catering catcateringDetails(@PathVariable int id){
<<<<<<< HEAD
        return CateringRepository.getCateringDtoById(id);
=======
        return CateringRepository.getCateringById(id);
>>>>>>> e2fa9c896ca14d4c45e84df3a514d002fa0e0b42
    }
}