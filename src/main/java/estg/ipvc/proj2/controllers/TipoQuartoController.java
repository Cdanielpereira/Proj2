package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipoquartodto.TipoQuartoDto;
import estg.ipvc.proj2.services.TipoQuartoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class TipoQuartoController {

    private final TipoQuartoService service;

    public TipoQuartoController(TipoQuartoService service) {
        this.service = service;
    }

    @GetMapping("/tipoquarto")
    public ResponseEntity<PageResponse<TipoQuartoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllTipoQuarto(pageNo, pageSize));
    }

    @GetMapping("/tipoquarto/{id}")
    public ResponseEntity<TipoQuartoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTipoQuartoById(id));
    }

    @PostMapping("/tipoquarto")
    public ResponseEntity<TipoQuartoDto> create(@RequestBody TipoQuartoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTipoQuarto(dto));
    }

    @PutMapping("/tipoquarto/{id}")
    public ResponseEntity<TipoQuartoDto> update(
            @RequestBody TipoQuartoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateTipoQuarto(dto, id));
    }

    @DeleteMapping("/tipoquarto/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteTipoQuarto(id);
        return ResponseEntity.noContent().build();
    }
}