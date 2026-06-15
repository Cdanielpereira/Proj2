package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.piscinadto.PiscinaDto;
import goodstay_api.services.PiscinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
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