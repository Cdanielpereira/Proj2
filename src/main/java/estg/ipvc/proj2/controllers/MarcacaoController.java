package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.marcacaodto.MarcacaoDto;
import estg.ipvc.proj2.services.MarcacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class MarcacaoController {

    private final MarcacaoService marcacaoService;

    @Autowired
    public MarcacaoController(MarcacaoService marcacaoService) {
        this.marcacaoService = marcacaoService;
    }

    @GetMapping("/marcacoes")
    public ResponseEntity<PageResponse<MarcacaoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                marcacaoService.getAllMarcacoes(pageNo, pageSize)
        );
    }

    @GetMapping("/marcacoes/{id}")
    public ResponseEntity<MarcacaoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                marcacaoService.getMarcacaoById(id)
        );
    }

    @PostMapping("/marcacoes")
    public ResponseEntity<MarcacaoDto> create(@RequestBody MarcacaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(marcacaoService.createMarcacao(dto));
    }

    @PutMapping("/marcacoes/{id}")
    public ResponseEntity<MarcacaoDto> update(
            @RequestBody MarcacaoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                marcacaoService.updateMarcacao(dto, id)
        );
    }

    @DeleteMapping("/marcacoes/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        marcacaoService.deleteMarcacao(id);
        return ResponseEntity.noContent().build();
    }
}