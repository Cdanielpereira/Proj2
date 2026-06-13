package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.manutencaodto.ManutencaoDto;
import estg.ipvc.proj2.services.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class ManutencaoController {

    private final ManutencaoService manutencaoService;

    @Autowired
    public ManutencaoController(ManutencaoService manutencaoService) {
        this.manutencaoService = manutencaoService;
    }

    @GetMapping("/manutencoes")
    public ResponseEntity<PageResponse<ManutencaoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                manutencaoService.getAllManutencao(pageNo, pageSize)
        );
    }

    @GetMapping("/manutencoes/{id}")
    public ResponseEntity<ManutencaoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                manutencaoService.getManutencaoById(id)
        );
    }

    @PostMapping("/manutencoes")
    public ResponseEntity<ManutencaoDto> create(@RequestBody ManutencaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(manutencaoService.createManutencao(dto));
    }

    @PutMapping("/manutencoes/{id}")
    public ResponseEntity<ManutencaoDto> update(
            @RequestBody ManutencaoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                manutencaoService.updateManutencao(dto, id)
        );
    }

    @DeleteMapping("/manutencoes/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        manutencaoService.deleteManutencao(id);
        return ResponseEntity.noContent().build();
    }
}