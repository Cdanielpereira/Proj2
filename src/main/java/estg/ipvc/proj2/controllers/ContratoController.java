package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.contratodto.ContratoDto;
import estg.ipvc.proj2.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
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