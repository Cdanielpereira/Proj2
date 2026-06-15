package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.metodopagamentodto.MetodoPagamentoDto;
import goodstay_api.services.MetodoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class MetodoPagamentoController {

    private final MetodoPagamentoService metodoPagamentoService;

    @Autowired
    public MetodoPagamentoController(MetodoPagamentoService metodoPagamentoService) {
        this.metodoPagamentoService = metodoPagamentoService;
    }

    @GetMapping("/metodos-pagamento")
    public ResponseEntity<PageResponse<MetodoPagamentoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                metodoPagamentoService.getAllMetodoPagamento(pageNo, pageSize)
        );
    }

    @GetMapping("/metodos-pagamento/{id}")
    public ResponseEntity<MetodoPagamentoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                metodoPagamentoService.getMetodoPagamentoById(id)
        );
    }

    @PostMapping("/metodos-pagamento")
    public ResponseEntity<MetodoPagamentoDto> create(
            @RequestBody MetodoPagamentoDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(metodoPagamentoService.createMetodoPagamento(dto));
    }

    @PutMapping("/metodos-pagamento/{id}")
    public ResponseEntity<MetodoPagamentoDto> update(
            @RequestBody MetodoPagamentoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                metodoPagamentoService.updateMetodoPagamento(dto, id)
        );
    }

    @DeleteMapping("/metodos-pagamento/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        metodoPagamentoService.deleteMetodoPagamento(id);
        return ResponseEntity.noContent().build();
    }
}