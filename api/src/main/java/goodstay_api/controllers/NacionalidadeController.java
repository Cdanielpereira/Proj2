package goodstay_api.controllers;

import goodstay_api.dtos.common.PageResponse;
import goodstay_api.dtos.nacionalidadedto.NacionalidadeDto;
import goodstay_api.services.NacionalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class NacionalidadeController {

    private final NacionalidadeService nacionalidadeService;

    @Autowired
    public NacionalidadeController(NacionalidadeService nacionalidadeService) {
        this.nacionalidadeService = nacionalidadeService;
    }

    @GetMapping("/nacionalidades")
    public ResponseEntity<PageResponse<NacionalidadeDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                nacionalidadeService.getAllNacionalidades(pageNo, pageSize)
        );
    }

    @GetMapping("/nacionalidades/{id}")
    public ResponseEntity<NacionalidadeDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                nacionalidadeService.getNacionalidadeById(id)
        );
    }

    @PostMapping("/nacionalidades")
    public ResponseEntity<NacionalidadeDto> create(@RequestBody NacionalidadeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(nacionalidadeService.createNacionalidade(dto));
    }

    @PutMapping("/nacionalidades/{id}")
    public ResponseEntity<NacionalidadeDto> update(
            @RequestBody NacionalidadeDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                nacionalidadeService.updateNacionalidade(dto, id)
        );
    }

    @DeleteMapping("/nacionalidades/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        nacionalidadeService.deleteNacionalidade(id);
        return ResponseEntity.noContent().build();
    }
}