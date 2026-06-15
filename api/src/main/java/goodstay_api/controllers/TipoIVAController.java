package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipoIVAdto.TipoIVADto;
import goodstay_api.services.TipoIVAService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class TipoIVAController {

    private final TipoIVAService service;

    public TipoIVAController(TipoIVAService service) {
        this.service = service;
    }

    @GetMapping("/tipoiva")
    public ResponseEntity<PageResponse<TipoIVADto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllTipoIVA(pageNo, pageSize));
    }

    @GetMapping("/tipoiva/{id}")
    public ResponseEntity<TipoIVADto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTipoIVAById(id));
    }

    @PostMapping("/tipoiva")
    public ResponseEntity<TipoIVADto> create(@RequestBody TipoIVADto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTipoIVA(dto));
    }

    @PutMapping("/tipoiva/{id}")
    public ResponseEntity<TipoIVADto> update(
            @RequestBody TipoIVADto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateTipoIVA(dto, id));
    }

    @DeleteMapping("/tipoiva/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteTipoIVA(id);
        return ResponseEntity.noContent().build();
    }
}