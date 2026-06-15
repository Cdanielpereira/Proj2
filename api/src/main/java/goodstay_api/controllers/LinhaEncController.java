package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.linhaencdto.LinhaEncDto;
import goodstay_api.services.LinhaEncService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class LinhaEncController {

    private final LinhaEncService service;

    public LinhaEncController(LinhaEncService service) {
        this.service = service;
    }

    @GetMapping("/linhaenc")
    public ResponseEntity<PageResponse<LinhaEncDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(service.getAllLinhaEnc(pageNo, pageSize));
    }

    @GetMapping("/linhaenc/{idEnco}/{idProduto}")
    public ResponseEntity<LinhaEncDto> getById(
            @PathVariable Integer idEnco,
            @PathVariable Integer idProduto
    ) {
        return ResponseEntity.ok(service.getLinhaEncById(idEnco, idProduto));
    }

    @PostMapping("/linhaenc")
    public ResponseEntity<LinhaEncDto> create(@RequestBody LinhaEncDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createLinhaEnc(dto));
    }

    @PutMapping("/linhaenc/{idEnco}/{idProduto}")
    public ResponseEntity<LinhaEncDto> update(
            @RequestBody LinhaEncDto dto,
            @PathVariable Integer idEnco,
            @PathVariable Integer idProduto
    ) {
        return ResponseEntity.ok(service.updateLinhaEnc(dto, idEnco, idProduto));
    }

    @DeleteMapping("/linhaenc/{idEnco}/{idProduto}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idEnco,
            @PathVariable Integer idProduto
    ) {
        service.deleteLinhaEnc(idEnco, idProduto);
        return ResponseEntity.noContent().build();
    }
}