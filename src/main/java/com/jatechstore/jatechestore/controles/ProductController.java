package com.jatechstore.jatechestore.controles;

import com.jatechstore.jatechestore.dto.ProductDTO;
import com.jatechstore.jatechestore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// Define que esta classe é um controlador REST
@RestController
// Define o mapeamento base da URL para este controlador
@RequestMapping(value = "/products")
public class ProductController {

    // Injeta automaticamente uma instância do serviço ProductService
    @Autowired
    private ProductService service;

    // Endpoint para buscar um produto pelo ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = service.findById(id);
        return ResponseEntity.ok(dto); // Retorna 200 OK com o produto encontrado
    }

    // Endpoint para buscar todos os produtos com suporte à paginação
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        Page<ProductDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto); // Retorna uma página de produtos
    }

    // Endpoint para inserir um novo produto
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
        dto = service.insert(dto);

        // Cria a URI do novo recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        // Retorna 201 Created com a URI do novo recurso no header "Location"
        return ResponseEntity.created(uri).body(dto);
    }

    // Endpoint para atualizar um produto existente
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto); // Retorna 200 OK com o produto atualizado
    }

    // Endpoint para deletar um produto pelo ID
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content após remoção com sucesso
    }

}
