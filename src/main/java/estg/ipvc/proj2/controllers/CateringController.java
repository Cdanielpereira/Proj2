package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.cateringdto.CateringDto;
import estg.ipvc.proj2.services.CateringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class CateringController {

    private final CateringService cateringService;

    @Autowired
    public CateringController(CateringService cateringService) {
        this.cateringService = cateringService;
    }

    @GetMapping("/catering")
    public ResponseEntity<PageResponse<CateringDto>> getCatering(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                cateringService.getAllCatering(pageNo, pageSize)
        );
    }

    @GetMapping("/catering/{id}")
    public ResponseEntity<CateringDto> getCateringById(@PathVariable int id) {
        return ResponseEntity.ok(
                cateringService.getCateringById(id)
        );
    }

    @PostMapping("/catering")
    public ResponseEntity<CateringDto> createCatering(@RequestBody CateringDto cateringDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cateringService.createCatering(cateringDto));
    }

    @PutMapping("/catering/{id}")
    public ResponseEntity<CateringDto> updateCatering(
            @RequestBody CateringDto cateringDto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                cateringService.updateCatering(cateringDto, id)
        );
    }

    @DeleteMapping("/catering/{id}")
    public ResponseEntity<Void> deleteCatering(@PathVariable int id) {
        cateringService.deleteCateringId(id);
        return ResponseEntity.noContent().build();
    }
}