package goodstay_api.controllers;

import goodstay_api.dtos.clientedto.ClienteDto;
import goodstay_api.dtos.common.PageResponse;
import goodstay_api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goodstay/api")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente")
    public ResponseEntity<PageResponse<ClienteDto>> getClientes(
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity.ok(
                clienteService.getAllClientes(pageNo, pageSize)
        );
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable int id) {
        return ResponseEntity.ok(
                clienteService.getClienteById(id)
        );
    }

    @PostMapping("/cliente")
    public ResponseEntity<ClienteDto> createCliente(
            @RequestBody ClienteDto clienteDto
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.createCliente(clienteDto));
    }

    @PutMapping("/cliente/{id}")
    public ResponseEntity<ClienteDto> updateCliente(
            @RequestBody ClienteDto clienteDto,
            @PathVariable int id
    ) {
        return ResponseEntity.ok(
                clienteService.updateCliente(clienteDto, id)
        );
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}