package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.reservadto.ReservaDto;
import estg.ipvc.proj2.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/reservas")
    public ResponseEntity<PageResponse<ReservaDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                reservaService.getAllReservas(pageNo, pageSize)
        );
    }

    @GetMapping("/reservas/{idMarc}/{nquarto}")
    public ResponseEntity<ReservaDto> getById(
            @PathVariable Integer idMarc,
            @PathVariable Integer nquarto
    ) {
        return ResponseEntity.ok(
                reservaService.getReservaById(idMarc, nquarto)
        );
    }

    @PostMapping("/reservas")
    public ResponseEntity<ReservaDto> create(@RequestBody ReservaDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservaService.createReserva(dto));
    }

    @PutMapping("/reservas/{idMarc}/{nquarto}")
    public ResponseEntity<ReservaDto> update(
            @RequestBody ReservaDto dto,
            @PathVariable Integer idMarc,
            @PathVariable Integer nquarto
    ) {
        return ResponseEntity.ok(
                reservaService.updateReserva(dto, idMarc, nquarto)
        );
    }

    @DeleteMapping("/reservas/{idMarc}/{nquarto}")
    public ResponseEntity<Void> delete(
            @PathVariable Integer idMarc,
            @PathVariable Integer nquarto
    ) {
        reservaService.deleteReserva(idMarc, nquarto);
        return ResponseEntity.noContent().build();
    }
}