package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.piscinadto.PiscinaDto;
import estg.ipvc.proj2.services.PiscinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class PiscinaController {

    private final PiscinaService piscinaService;

    @Autowired
    public PiscinaController(PiscinaService piscinaService) {
        this.piscinaService = piscinaService;
    }

    @GetMapping("/piscinas")
    public ResponseEntity<PageResponse<PiscinaDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                piscinaService.getAllPiscinas(pageNo, pageSize)
        );
    }

    @GetMapping("/piscinas/{id}")
    public ResponseEntity<PiscinaDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                piscinaService.getPiscinaById(id)
        );
    }

    @PostMapping("/piscinas")
    public ResponseEntity<PiscinaDto> create(@RequestBody PiscinaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(piscinaService.createPiscina(dto));
    }

    @PutMapping("/piscinas/{id}")
    public ResponseEntity<PiscinaDto> update(
            @RequestBody PiscinaDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                piscinaService.updatePiscina(dto, id)
        );
    }

    @DeleteMapping("/piscinas/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        piscinaService.deletePiscina(id);
        return ResponseEntity.noContent().build();
    }
}