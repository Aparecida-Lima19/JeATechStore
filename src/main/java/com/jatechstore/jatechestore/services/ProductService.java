package com.jatechstore.jatechestore.services;

import com.jatechstore.jatechestore.dto.ProductDTO;
import com.jatechstore.jatechestore.entities.Product;
import com.jatechstore.jatechestore.repositories.ProductRepository;
import com.jatechstore.jatechestore.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.boot.model.relational.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Service // Indica que esta classe é um componente de serviço do Spring
public class ProductService {

    @Autowired
    private ProductRepository repository; // Injeta o repositório de produtos

    // Método para buscar um produto por ID (apenas leitura, com controle de transação)
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        // Busca o produto pelo ID ou lança exceção se não encontrar
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado!"));
        return new ProductDTO(product); // Retorna o DTO correspondente
    }

    // Retorna uma lista paginada de produtos
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x)); // Converte Page<Product> em Page<ProductDTO>
    }

    // Insere um novo produto no banco de dados
    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoEntity(dto, entity);
        entity = repository.save(entity);
        return new ProductDTO(entity);
    }

    // Atualiza um produto existente
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {
        try {
            // Obtém uma referência ao produto pelo ID
            Product entity = repository.getReferenceById(id);
            copyDtoEntity(dto, entity);
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }

    // Deleta um produto pelo ID
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
        repository.deleteById(id);
    }

    // Método auxiliar que copia os dados do DTO para a entidade
    private void copyDtoEntity(ProductDTO dto, Product entity) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());
    }

}
