package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.encomendadto.EncomendaDto;
import goodstay_api.services.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class EncomendaController {

    private final EncomendaService encomendaService;

    @Autowired
    public EncomendaController(EncomendaService encomendaService) {
        this.encomendaService = encomendaService;
    }

    @GetMapping("/encomenda")
    public ResponseEntity<PageResponse<EncomendaDto>> getEncomendas(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                encomendaService.getAllEncomendas(pageNo, pageSize)
        );
    }

    @GetMapping("/encomenda/{id}")
    public ResponseEntity<EncomendaDto> getEncomendaById(@PathVariable int id) {
        return ResponseEntity.ok(
                encomendaService.getEncomendaById(id)
        );
    }

    @PostMapping("/encomenda")
    public ResponseEntity<EncomendaDto> createEncomenda(@RequestBody EncomendaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(encomendaService.createEncomenda(dto));
    }

    @PutMapping("/encomenda/{id}")
    public ResponseEntity<EncomendaDto> updateEncomenda(
            @RequestBody EncomendaDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                encomendaService.updateEncomenda(dto, id)
        );
    }

    @DeleteMapping("/encomenda/{id}")
    public ResponseEntity<Void> deleteEncomenda(@PathVariable int id) {
        encomendaService.deleteEncomenda(id);
        return ResponseEntity.noContent().build();
    }
}