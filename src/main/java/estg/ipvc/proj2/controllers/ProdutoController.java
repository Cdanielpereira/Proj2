package estg.ipvc.proj2.controllers;

import estg.ipvc.proj2.dtos.common.PageResponse;
import estg.ipvc.proj2.dtos.produtodto.ProdutoDto;
import estg.ipvc.proj2.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proj2")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public ResponseEntity<PageResponse<ProdutoDto>> getAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                produtoService.getAllProdutos(pageNo, pageSize)
        );
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoDto> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                produtoService.getProdutoById(id)
        );
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoDto> create(@RequestBody ProdutoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.createProduto(dto));
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<ProdutoDto> update(
            @RequestBody ProdutoDto dto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                produtoService.updateProduto(dto, id)
        );
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        produtoService.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}