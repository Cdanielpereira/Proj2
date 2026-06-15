package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.linhamanudto.LinhaManuDto;
import goodstay_api.services.LinhaManuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class LinhaManuController {

    private final LinhaManuService service;

    public LinhaManuController(LinhaManuService service) {
        this.service = service;
    }

    @GetMapping("/linhamanu")
    public ResponseEntity<PageResponse<LinhaManuDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllLinhaManu(pageNo, pageSize));
    }

    @GetMapping("/linhamanu/{idManu}/{idServico}")
    public ResponseEntity<LinhaManuDto> getById(
            @PathVariable Integer idManu,
            @PathVariable Integer idServico
    ) {
        return ResponseEntity.ok(service.getLinhaManuById(idManu, idServico));
    }

    @PostMapping("/linhamanu")
    public ResponseEntity<LinhaManuDto> create(@RequestBody LinhaManuDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createLinhaManu(dto));
    }

    @PutMapping("/linhamanu/{idManu}/{idServico}")
    public ResponseEntity<LinhaManuDto> update(
            @RequestBody LinhaManuDto dto,
            @PathVariable Integer idManu,
            @PathVariable Integer idServico
    ) {
        return ResponseEntity.ok(service.updateLinhaManu(dto, idManu, idServico));
    }

    @DeleteMapping("/linhamanu/{idManu}/{idServico}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idManu,
            @PathVariable Integer idServico
    ) {
        service.deleteLinhaManu(idManu, idServico);
        return ResponseEntity.noContent().build();
    }
}