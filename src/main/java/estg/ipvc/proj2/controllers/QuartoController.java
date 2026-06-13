package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.quartodto.QuartoDto;
import estg.ipvc.proj2.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class QuartoController {

    private final QuartoService quartoService;

    @Autowired
    public QuartoController(QuartoService quartoService) {
        this.quartoService = quartoService;
    }

    @GetMapping("/quartos")
    public ResponseEntity<PageResponse<QuartoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                quartoService.getAllQuartos(pageNo, pageSize)
        );
    }

    @GetMapping("/quartos/{id}")
    public ResponseEntity<QuartoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                quartoService.getQuartoById(id)
        );
    }

    @PostMapping("/quartos")
    public ResponseEntity<QuartoDto> create(@RequestBody QuartoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(quartoService.createQuarto(dto));
    }

    @PutMapping("/quartos/{id}")
    public ResponseEntity<QuartoDto> update(
            @RequestBody QuartoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                quartoService.updateQuarto(dto, id)
        );
    }

    @DeleteMapping("/quartos/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        quartoService.deleteQuarto(id);
        return ResponseEntity.noContent().build();
    }
}