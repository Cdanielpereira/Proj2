package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadoservicodto.EstadoServicoDto;
import estg.ipvc.proj2.services.EstadoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class EstadoServicoController {

    private final EstadoServicoService estadoServicoService;

    @Autowired
    public EstadoServicoController(EstadoServicoService estadoServicoService) {
        this.estadoServicoService = estadoServicoService;
    }

    @GetMapping("/estado-servico")
    public ResponseEntity<PageResponse<EstadoServicoDto>> getEstadoServicos(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                estadoServicoService.getAllEstadoServicos(pageNo, pageSize)
        );
    }

    @GetMapping("/estado-servico/{id}")
    public ResponseEntity<EstadoServicoDto> getEstadoServicoById(@PathVariable int id) {
        return ResponseEntity.ok(
                estadoServicoService.getEstadoServicoById(id)
        );
    }

    @PostMapping("/estado-servico")
    public ResponseEntity<EstadoServicoDto> createEstadoServico(
            @RequestBody EstadoServicoDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estadoServicoService.createEstadoServico(dto));
    }

    @PutMapping("/estado-servico/{id}")
    public ResponseEntity<EstadoServicoDto> updateEstadoServico(
            @RequestBody EstadoServicoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                estadoServicoService.updateEstadoServico(dto, id)
        );
    }

    @DeleteMapping("/estado-servico/{id}")
    public ResponseEntity<Void> deleteEstadoServico(@PathVariable int id) {
        estadoServicoService.deleteEstadoServico(id);
        return ResponseEntity.noContent().build();
    }
}