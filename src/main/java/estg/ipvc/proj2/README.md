# Guia de Criaçõo de Services
## O que são Services?
Os Services são classes que implementam a lógica de neg�cio da aplicão, separando-a dos controllers e repositories. Seguem o padrão **Service Layer** em Spring Boot.
## Estrutura de um Service
Um service tópico em Spring Boot possui a seguinte estrutura:
    
    java package estg.ipvc.proj2.impl;
    import estg.ipvc.proj2.model.MinhaEntidade;
    import estg.ipvc.proj2.repository.MinhaEntidadeRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class MinhaEntidadeService {

    @Autowired
    private MinhaEntidadeRepository minhaEntidadeRepository;
    // Obter todos os registos
    public List<MinhaEntidade> getAll() {
        return (List<MinhaEntidade>) minhaEntidadeRepository.findAll();
    }
    // Obter por ID
    public Optional<MinhaEntidade> getById(Integer id) {return minhaEntidadeRepository.findById(id);}
    // Criar novo
    public MinhaEntidade create(MinhaEntidade entidade) {return minhaEntidadeRepository.save(entidade);}
    // Atualizar
    public MinhaEntidade update(Integer id, MinhaEntidade entidade) {
        if (minhaEntidadeRepository.existsById(id)) {
            entidade.setId(id);  // ajustar nome do ID conforme a entidade
            return minhaEntidadeRepository.save(entidade);
        }
        return null;
    }
    // Eliminar
    public void delete(Integer id) {minhaEntidadeRepository.deleteById(id);}
    // Verificar existência
    public boolean exists(Integer id) {return minhaEntidadeRepository.existsById(id);}
}
\\\
## Como Criar Services para seu projeto
### Passo 1: Identificar a Entidade
Cada service corresponde a uma entidade no package \model\.
### Passo 2: Verificar o Repository
Confirme que existe um Repository correspondente em \repository\.
### Passo 3: Criar a Classe Service
1. Crie um ficheiro \NomeEntidadeService.java\ nesta pasta
2. Siga a estrutura acima
3. Adapte o nome do método set do ID (pode ser \setId\, \setIdCliente\, etc.)
### Passo 4: Usar em Controllers
Injete o service no controller:

    java
    
    @RestController
    
    @RequestMapping(\"/api/minhaentidade\")
    public class MinhaEntidadeController {
    
    @Autowired
    private MinhaEntidadeService service;
    
    @GetMapping
    public List<MinhaEntidade> getAll() {return service.getAll();}
    
    @GetMapping(\"/{id}\")
    public Optional<MinhaEntidade> getById(@PathVariable Integer id) {return service.getById(id);}
    
    @PostMapping
    public MinhaEntidade create(@RequestBody MinhaEntidade entidade) {return service.create(entidade);}
    
    @PutMapping(\"/{id}\")
    public MinhaEntidade update(@PathVariable Integer id, @RequestBody MinhaEntidade entidade) {
        return service.update(id, entidade);
    }
    
    @DeleteMapping(\"/{id}\")
    public void delete(@PathVariable Integer id) {service.delete(id);}
}

## Serviços Já Criados
? UserService
? ClienteService
## Próximos Services a Criar
Recomenda-se criar services para as seguintes entidades:
- Funcionario
- Colaborador
- Contrato
- Reserva
- Encomenda
- Fatura*
- E outras conforme necessário
## Padrões Importantes
1. **@Service**: Anotação que marca a classe como um service
2. **@Autowired**: Injeta o repository automaticamente
3. **CrudRepository**: Interface que fornece operações CRUD básicas
## Boas Práticas
- Sempre verificar se a entidade existe antes de atualizar ou eliminar
- Usar Optional para retornos que podem ser null
- Adicionar validações conforme necessário
- Documentar métodos com comentários JavaDoc quando apropriado
