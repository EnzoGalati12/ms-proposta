package br.com.enzogalati12.ms_proposta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private  String nome;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private BigDecimal renda;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Proposta> propostas = new ArrayList<>();
}
