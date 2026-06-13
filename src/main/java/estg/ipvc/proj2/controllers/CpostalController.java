package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.cpostaldto.CpostalDto;
import estg.ipvc.proj2.services.CpostalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class CpostalController {

    private final CpostalService cpostalService;

    @Autowired
    public CpostalController(CpostalService cpostalService) {
        this.cpostalService = cpostalService;
    }

    @GetMapping("/cpostal")
    public ResponseEntity<PageResponse<CpostalDto>> getCpostal(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                cpostalService.getAllCpostal(pageNo, pageSize)
        );
    }

    @GetMapping("/cpostal/{codPostal}")
    public ResponseEntity<CpostalDto> getCpostalById(
            @PathVariable String codPostal
    ) {
        return ResponseEntity.ok(
                cpostalService.getCpostalById(codPostal)
        );
    }

    @PostMapping("/cpostal")
    public ResponseEntity<CpostalDto> createCpostal(
            @RequestBody CpostalDto cpostalDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cpostalService.createCpostal(cpostalDto));
    }

    @PutMapping("/cpostal/{codPostal}")
    public ResponseEntity<CpostalDto> updateCpostal(
            @RequestBody CpostalDto cpostalDto,
            @PathVariable String codPostal
    ) {
        return ResponseEntity.ok(
                cpostalService.updateCpostal(cpostalDto, codPostal)
        );
    }

    @DeleteMapping("/cpostal/{codPostal}")
    public ResponseEntity<Void> deleteCpostal(
            @PathVariable String codPostal
    ) {
        cpostalService.deleteCpostalId(codPostal);
        return ResponseEntity.noContent().build();
    }
}