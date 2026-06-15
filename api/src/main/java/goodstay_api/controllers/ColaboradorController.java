package goodstay_api.controllers;

import goodstay_api.dtos.colaboradordto.ColaboradorDto;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @Autowired
    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("/colaborador")
    public ResponseEntity<PageResponse<ColaboradorDto>> getColaboradores(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                colaboradorService.getAllColaboradores(pageNo, pageSize)
        );
    }

    @GetMapping("/colaborador/{id}")
    public ResponseEntity<ColaboradorDto> getColaboradorById(@PathVariable int id) {
        return ResponseEntity.ok(
                colaboradorService.getColaboradorById(id)
        );
    }

    @PostMapping("/colaborador")
    public ResponseEntity<ColaboradorDto> createColaborador(
            @RequestBody ColaboradorDto colaboradorDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(colaboradorService.createColaborador(colaboradorDto));
    }

    @PutMapping("/colaborador/{id}")
    public ResponseEntity<ColaboradorDto> updateColaborador(
            @RequestBody ColaboradorDto colaboradorDto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                colaboradorService.updateColaborador(colaboradorDto, id)
        );
    }

    @DeleteMapping("/colaborador/{id}")
    public ResponseEntity<Void> deleteColaborador(@PathVariable int id) {
        colaboradorService.deleteColaboradorId(id);
        return ResponseEntity.noContent().build();
    }
}