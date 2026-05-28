package com.hardware.marcos.hardwarestockapi.produtos;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "produto")  // Define o nome da tabela no banco de dados
@Entity(name = "produtos") // Marca a classe como uma entidade JPA e define o nome da entidade
@Getter // Gera automaticamente os métodos getters (Lombok)
@Setter // Gera automaticamente os métodos setters (Lombok)
@AllArgsConstructor // Cria construtor com todos os atributos (Lombok)
@NoArgsConstructor // Cria construtor vazio (Lombok)
@EqualsAndHashCode(of = "id") // Compara objetos usando apenas o ID (Lombok)
public class Produto {

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
        this.sku = dados.sku();
        this.categoria = dados.categoria();
    }

    @Id  // Define o atributo como chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidade;
    private String sku;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;
}