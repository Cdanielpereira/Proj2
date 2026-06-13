package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.estadocontractdto.EstadoContractDto;
import estg.ipvc.proj2.services.EstadoContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class EstadoContractController {

    private final EstadoContractService estadoContractService;

    @Autowired
    public EstadoContractController(EstadoContractService estadoContractService) {
        this.estadoContractService = estadoContractService;
    }

    @GetMapping("/estado-contract")
    public ResponseEntity<PageResponse<EstadoContractDto>> getEstadoContracts(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                estadoContractService.getAllEstadoContracts(pageNo, pageSize)
        );
    }

    @GetMapping("/estado-contract/{id}")
    public ResponseEntity<EstadoContractDto> getEstadoContractById(@PathVariable int id) {
        return ResponseEntity.ok(
                estadoContractService.getEstadoContractById(id)
        );
    }

    @PostMapping("/estado-contract")
    public ResponseEntity<EstadoContractDto> createEstadoContract(
            @RequestBody EstadoContractDto dto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(estadoContractService.createEstadoContract(dto));
    }

    @PutMapping("/estado-contract/{id}")
    public ResponseEntity<EstadoContractDto> updateEstadoContract(
            @RequestBody EstadoContractDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                estadoContractService.updateEstadoContract(dto, id)
        );
    }

    @DeleteMapping("/estado-contract/{id}")
    public ResponseEntity<Void> deleteEstadoContract(@PathVariable int id) {
        estadoContractService.deleteEstadoContract(id);
        return ResponseEntity.noContent().build();
    }
}