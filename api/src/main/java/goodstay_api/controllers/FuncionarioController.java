package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.funcionariodto.FuncionarioDto;
import goodstay_api.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping("/funcionario")
    public ResponseEntity<PageResponse<FuncionarioDto>> getFuncionarios(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                funcionarioService.getAllFuncionarios(pageNo, pageSize)
        );
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<FuncionarioDto> getFuncionarioById(@PathVariable int id) {
        return ResponseEntity.ok(
                funcionarioService.getFuncionarioById(id)
        );
    }

    @PostMapping("/funcionario")
    public ResponseEntity<FuncionarioDto> createFuncionario(
            @RequestBody FuncionarioDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(funcionarioService.createFuncionario(dto));
    }

    @PutMapping("/funcionario/{id}")
    public ResponseEntity<FuncionarioDto> updateFuncionario(
            @RequestBody FuncionarioDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                funcionarioService.updateFuncionario(dto, id)
        );
    }

    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<Void> deleteFuncionario(@PathVariable int id) {
        funcionarioService.deleteFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}