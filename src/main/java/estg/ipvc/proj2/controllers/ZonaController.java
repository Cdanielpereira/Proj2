package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.zonadto.ZonaDto;
import estg.ipvc.proj2.services.ZonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class ZonaController {

    private final ZonaService service;

    public ZonaController(ZonaService service) {
        this.service = service;
    }

    @GetMapping("/zonas")
    public ResponseEntity<PageResponse<ZonaDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllZonas(pageNo, pageSize));
    }

    @GetMapping("/zonas/{id}")
    public ResponseEntity<ZonaDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getZonaById(id));
    }

    @PostMapping("/zonas")
    public ResponseEntity<ZonaDto> create(@RequestBody ZonaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createZona(dto));
    }

    @PutMapping("/zonas/{id}")
    public ResponseEntity<ZonaDto> update(
            @RequestBody ZonaDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateZona(dto, id));
    }

    @DeleteMapping("/zonas/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteZona(id);
        return ResponseEntity.noContent().build();
    }
}