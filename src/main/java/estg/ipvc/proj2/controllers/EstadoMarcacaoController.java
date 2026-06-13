package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadomarcacaodto.EstadoMarcacaoDto;
import estg.ipvc.proj2.services.EstadoMarcacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class EstadoMarcacaoController {

    private final EstadoMarcacaoService estadoMarcacaoService;

    @Autowired
    public EstadoMarcacaoController(EstadoMarcacaoService estadoMarcacaoService) {
        this.estadoMarcacaoService = estadoMarcacaoService;
    }

    @GetMapping("/estado-marcacao")
    public ResponseEntity<PageResponse<EstadoMarcacaoDto>> getEstadoMarcacoes(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                estadoMarcacaoService.getAllEstadoMarcacoes(pageNo, pageSize)
        );
    }

    @GetMapping("/estado-marcacao/{id}")
    public ResponseEntity<EstadoMarcacaoDto> getEstadoMarcacaoById(@PathVariable int id) {
        return ResponseEntity.ok(
                estadoMarcacaoService.getEstadoMarcacaoById(id)
        );
    }

    @PostMapping("/estado-marcacao")
    public ResponseEntity<EstadoMarcacaoDto> createEstadoMarcacao(
            @RequestBody EstadoMarcacaoDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estadoMarcacaoService.createEstadoMarcacao(dto));
    }

    @PutMapping("/estado-marcacao/{id}")
    public ResponseEntity<EstadoMarcacaoDto> updateEstadoMarcacao(
            @RequestBody EstadoMarcacaoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                estadoMarcacaoService.updateEstadoMarcacao(dto, id)
        );
    }

    @DeleteMapping("/estado-marcacao/{id}")
    public ResponseEntity<Void> deleteEstadoMarcacao(@PathVariable int id) {
        estadoMarcacaoService.deleteEstadoMarcacao(id);
        return ResponseEntity.noContent().build();
    }
}