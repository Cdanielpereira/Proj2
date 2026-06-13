package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.faturarecibodto.FaturaReciboDto;
import estg.ipvc.proj2.services.FaturaReciboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class FaturaReciboController {

    private final FaturaReciboService faturaReciboService;

    @Autowired
    public FaturaReciboController(FaturaReciboService faturaReciboService) {
        this.faturaReciboService = faturaReciboService;
    }

    @GetMapping("/fatura-recibo")
    public ResponseEntity<PageResponse<FaturaReciboDto>> getFaturaRecibos(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                faturaReciboService.getAllFaturaRecibos(pageNo, pageSize)
        );
    }

    @GetMapping("/fatura-recibo/{id}")
    public ResponseEntity<FaturaReciboDto> getFaturaReciboById(@PathVariable int id) {
        return ResponseEntity.ok(
                faturaReciboService.getFaturaReciboById(id)
        );
    }

    @PostMapping("/fatura-recibo")
    public ResponseEntity<FaturaReciboDto> createFaturaRecibo(
            @RequestBody FaturaReciboDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(faturaReciboService.createFaturaRecibo(dto));
    }

    @PutMapping("/fatura-recibo/{id}")
    public ResponseEntity<FaturaReciboDto> updateFaturaRecibo(
            @RequestBody FaturaReciboDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                faturaReciboService.updateFaturaRecibo(dto, id)
        );
    }

    @DeleteMapping("/fatura-recibo/{id}")
    public ResponseEntity<Void> deleteFaturaRecibo(@PathVariable int id) {
        faturaReciboService.deleteFaturaRecibo(id);
        return ResponseEntity.noContent().build();
    }
}