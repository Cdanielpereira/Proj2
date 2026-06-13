package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.tipocolabdto.TipoColabDto;
import estg.ipvc.proj2.services.TipoColabService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class TipoColabController {

    private final TipoColabService service;

    public TipoColabController(TipoColabService service) {
        this.service = service;
    }

    @GetMapping("/tipocolab")
    public ResponseEntity<PageResponse<TipoColabDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllTipoColab(pageNo, pageSize));
    }

    @GetMapping("/tipocolab/{id}")
    public ResponseEntity<TipoColabDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTipoColabById(id));
    }

    @PostMapping("/tipocolab")
    public ResponseEntity<TipoColabDto> create(@RequestBody TipoColabDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTipoColab(dto));
    }

    @PutMapping("/tipocolab/{id}")
    public ResponseEntity<TipoColabDto> update(
            @RequestBody TipoColabDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateTipoColab(dto, id));
    }

    @DeleteMapping("/tipocolab/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteTipoColab(id);
        return ResponseEntity.noContent().build();
    }
}