package estg.ipvc.proj2.controllers;

import CateringResponse;
import CateringDto;
import estg.ipvc.proj2.services.CateringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/proj2/")

public class CateringController {

    private CateringService cateringService;

    @Autowired
     public CateringController(CateringService cateringService) {
        this.cateringService = cateringService;
    }

    @GetMapping("catering")
    public ResponseEntity<CateringResponse> getCatering(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return new ResponseEntity<>(cateringService.getAllCatering(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("catering/{id}")
    public ResponseEntity<CateringDto> pokemonDetail(@PathVariable int id) {
        return ResponseEntity.ok(cateringService.getCateringById(id));

    }

    @PostMapping("catering/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CateringDto> createPokemon(@RequestBody CateringDto cateringDto) {
        return new ResponseEntity<>(cateringService.createCatering(cateringDto), HttpStatus.CREATED);
    }

    @PutMapping("catering/{id}/update")
    public ResponseEntity<CateringDto> updatePokemon(@RequestBody CateringDto cateringDto, @PathVariable("id") int cateringId) {
        CateringDto response = cateringService.updateCatering(cateringDto, cateringId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId) {
        cateringService.deleteCateringnId(cateringId);
        return new ResponseEntity<>("Catering delete", HttpStatus.OK);
    }

}