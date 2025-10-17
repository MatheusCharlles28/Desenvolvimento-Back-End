package com.exemplo.produto.service;

import com.exemplo.produto.model.Produto;
import com.exemplo.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public List<Produto> listar() {
        return repo.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Produto salvar(Produto produto) {
        return repo.save(produto);
    }

    public void remover(Long id) {
        repo.deleteById(id);
    }
}
