package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipozonadto.TipoZonaDto;
import estg.ipvc.proj2.services.TipoZonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class TipoZonaController {

    private final TipoZonaService service;

    public TipoZonaController(TipoZonaService service) {
        this.service = service;
    }

    @GetMapping("/tipozona")
    public ResponseEntity<PageResponse<TipoZonaDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllTipoZona(pageNo, pageSize));
    }

    @GetMapping("/tipozona/{id}")
    public ResponseEntity<TipoZonaDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTipoZonaById(id));
    }

    @PostMapping("/tipozona")
    public ResponseEntity<TipoZonaDto> create(@RequestBody TipoZonaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTipoZona(dto));
    }

    @PutMapping("/tipozona/{id}")
    public ResponseEntity<TipoZonaDto> update(
            @RequestBody TipoZonaDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateTipoZona(dto, id));
    }

    @DeleteMapping("/tipozona/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteTipoZona(id);
        return ResponseEntity.noContent().build();
    }
}