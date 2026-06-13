package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.servicodto.ServicoDto;
import estg.ipvc.proj2.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class ServicoController {

    private final ServicoService servicoService;

    @Autowired
    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping("/servicos")
    public ResponseEntity<PageResponse<ServicoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                servicoService.getAllServicos(pageNo, pageSize)
        );
    }

    @GetMapping("/servicos/{id}")
    public ResponseEntity<ServicoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                servicoService.getServicoById(id)
        );
    }

    @PostMapping("/servicos")
    public ResponseEntity<ServicoDto> create(@RequestBody ServicoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(servicoService.createServico(dto));
    }

    @PutMapping("/servicos/{id}")
    public ResponseEntity<ServicoDto> update(
            @RequestBody ServicoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                servicoService.updateServico(dto, id)
        );
    }

    @DeleteMapping("/servicos/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        servicoService.deleteServico(id);
        return ResponseEntity.noContent().build();
    }
}