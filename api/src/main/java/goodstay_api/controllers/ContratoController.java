package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.contratodto.ContratoDto;
import goodstay_api.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class ContratoController {

    private final ContratoService contratoService;

    @Autowired
    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping("/contrato")
    public ResponseEntity<PageResponse<ContratoDto>> getContratos(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                contratoService.getAllContratos(pageNo, pageSize)
        );
    }

    @GetMapping("/contrato/{id}")
    public ResponseEntity<ContratoDto> getContratoById(@PathVariable int id) {
        return ResponseEntity.ok(
                contratoService.getContratoById(id)
        );
    }

    @PostMapping("/contrato")
    public ResponseEntity<ContratoDto> createContrato(
            @RequestBody ContratoDto contratoDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contratoService.createContrato(contratoDto));
    }

    @PutMapping("/contrato/{id}")
    public ResponseEntity<ContratoDto> updateContrato(
            @RequestBody ContratoDto contratoDto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                contratoService.updateContrato(contratoDto, id)
        );
    }

    @DeleteMapping("/contrato/{id}")
    public ResponseEntity<Void> deleteContrato(@PathVariable int id) {
        contratoService.deleteContratoId(id);
        return ResponseEntity.noContent().build();
    }
}