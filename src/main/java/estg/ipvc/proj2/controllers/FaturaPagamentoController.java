package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.faturapagamentodto.FaturaPagamentoDto;
import estg.ipvc.proj2.services.FaturaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class FaturaPagamentoController {

    private final FaturaPagamentoService faturaPagamentoService;

    @Autowired
    public FaturaPagamentoController(FaturaPagamentoService faturaPagamentoService) {
        this.faturaPagamentoService = faturaPagamentoService;
    }

    @GetMapping("/fatura-pagamento")
    public ResponseEntity<PageResponse<FaturaPagamentoDto>> getFaturaPagamentos(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                faturaPagamentoService.getAllFaturaPagamentos(pageNo, pageSize)
        );
    }

    @GetMapping("/fatura-pagamento/{id}")
    public ResponseEntity<FaturaPagamentoDto> getFaturaPagamentoById(@PathVariable int id) {
        return ResponseEntity.ok(
                faturaPagamentoService.getFaturaPagamentoById(id)
        );
    }

    @PostMapping("/fatura-pagamento")
    public ResponseEntity<FaturaPagamentoDto> createFaturaPagamento(
            @RequestBody FaturaPagamentoDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(faturaPagamentoService.createFaturaPagamento(dto));
    }

    @PutMapping("/fatura-pagamento/{id}")
    public ResponseEntity<FaturaPagamentoDto> updateFaturaPagamento(
            @RequestBody FaturaPagamentoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                faturaPagamentoService.updateFaturaPagamento(dto, id)
        );
    }

    @DeleteMapping("/fatura-pagamento/{id}")
    public ResponseEntity<Void> deleteFaturaPagamento(@PathVariable int id) {
        faturaPagamentoService.deleteFaturaPagamento(id);
        return ResponseEntity.noContent().build();
    }
}