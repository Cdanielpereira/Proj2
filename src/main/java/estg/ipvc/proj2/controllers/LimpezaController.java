package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.limpezadto.LimpezaDto;
import estg.ipvc.proj2.services.LimpezaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class LimpezaController {

    private final LimpezaService service;

    public LimpezaController(LimpezaService service) {
        this.service = service;
    }

    @GetMapping("/limpezas")
    public ResponseEntity<PageResponse<LimpezaDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllLimpezas(pageNo, pageSize));
    }

    @GetMapping("/limpezas/{idZona}/{idFunc}")
    public ResponseEntity<LimpezaDto> getById(
            @PathVariable Integer idZona,
            @PathVariable Integer idFunc
    ) {
        return ResponseEntity.ok(service.getLimpezaById(idZona, idFunc));
    }

    @PostMapping("/limpezas")
    public ResponseEntity<LimpezaDto> create(@RequestBody LimpezaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createLimpeza(dto));
    }

    @PutMapping("/limpezas/{idZona}/{idFunc}")
    public ResponseEntity<LimpezaDto> update(
            @RequestBody LimpezaDto dto,
            @PathVariable Integer idZona,
            @PathVariable Integer idFunc
    ) {
        return ResponseEntity.ok(service.updateLimpeza(dto, idZona, idFunc));
    }

    @DeleteMapping("/limpezas/{idZona}/{idFunc}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idZona,
            @PathVariable Integer idFunc
    ) {
        service.deleteLimpeza(idZona, idFunc);
        return ResponseEntity.noContent().build();
    }
}