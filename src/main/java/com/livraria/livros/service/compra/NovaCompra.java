package com.livraria.livros.service.compra;

import com.livraria.livros.model.CompraModel;
import com.livraria.livros.repository.LivrosRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class NovaCompra {

    private Long id;

    private List<NovoItemCompra> itens;

    private List<String> cupons;

    @Override
    public String toString() {
        return "NovaCompra{" +
                "id=" + id +
                ", itens=" + itens +
                ", cupons=" + cupons +
                '}';
    }

    public CompraModel toModel(LivrosRepository repository) {
        var compra = new CompraModel();
        for (var item: itens) {
            var newItem = item.toModel(repository);
            compra.addItem(newItem);
        }
        compra.getCupons().addAll(cupons);
        return compra;
    }
}
