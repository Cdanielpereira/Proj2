package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.tipofuncdto.TipoFuncDto;
import goodstay_api.services.TipoFuncService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class TipoFuncController {

    private final TipoFuncService service;

    public TipoFuncController(TipoFuncService service) {
        this.service = service;
    }

    @GetMapping("/tipofunc")
    public ResponseEntity<PageResponse<TipoFuncDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllTipoFunc(pageNo, pageSize));
    }

    @GetMapping("/tipofunc/{id}")
    public ResponseEntity<TipoFuncDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTipoFuncById(id));
    }

    @PostMapping("/tipofunc")
    public ResponseEntity<TipoFuncDto> create(@RequestBody TipoFuncDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createTipoFunc(dto));
    }

    @PutMapping("/tipofunc/{id}")
    public ResponseEntity<TipoFuncDto> update(
            @RequestBody TipoFuncDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateTipoFunc(dto, id));
    }

    @DeleteMapping("/tipofunc/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteTipoFunc(id);
        return ResponseEntity.noContent().build();
    }
}