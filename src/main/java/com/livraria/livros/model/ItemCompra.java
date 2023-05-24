package com.livraria.livros.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Embeddable
@Getter
@NoArgsConstructor
public class ItemCompra {

    @ManyToOne
    private LivrosModel livrosModel;

    private Integer quantidade;

    @Column(precision = 4)
    private BigDecimal total;

    @Builder
    public ItemCompra(LivrosModel livrosModel, Integer quantidade, BigDecimal total) {
        this.livrosModel = livrosModel;
        this.quantidade = quantidade;
        this.total = Optional
                .ofNullable(livrosModel.getPreco()).orElse(BigDecimal.ZERO)
                .multiply(BigDecimal.valueOf(this.quantidade))
                .setScale(4, RoundingMode.HALF_EVEN);
    }


}
