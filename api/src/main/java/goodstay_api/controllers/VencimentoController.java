package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.vencimentodto.VencimentoDto;
import goodstay_api.services.VencimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class VencimentoController {

    private final VencimentoService service;

    public VencimentoController(VencimentoService service) {
        this.service = service;
    }

    @GetMapping("/vencimentos")
    public ResponseEntity<PageResponse<VencimentoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllVencimentos(pageNo, pageSize));
    }

    @GetMapping("/vencimentos/{id}")
    public ResponseEntity<VencimentoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getVencimentoById(id));
    }

    @PostMapping("/vencimentos")
    public ResponseEntity<VencimentoDto> create(@RequestBody VencimentoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createVencimento(dto));
    }

    @PutMapping("/vencimentos/{id}")
    public ResponseEntity<VencimentoDto> update(
            @RequestBody VencimentoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(service.updateVencimento(dto, id));
    }

    @DeleteMapping("/vencimentos/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteVencimento(id);
        return ResponseEntity.noContent().build();
    }
}