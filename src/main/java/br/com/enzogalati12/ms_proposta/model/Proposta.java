package br.com.enzogalati12.ms_proposta.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "tb_proposta")
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private BigDecimal valorSolicitado;
    @Column(nullable = false)
    private Integer prazoParaPagamento;

    private Boolean aprovado = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

}
