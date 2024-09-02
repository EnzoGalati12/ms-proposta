package br.com.enzogalati12.ms_proposta.dto;

import br.com.enzogalati12.ms_proposta.model.Proposta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PropostaDTO {

    private Long id;

    @Positive(message = "O valor deve ser positivo")
    @NotNull(message = "Campo obrigatório")
    private BigDecimal valorSolicitado;

    @Positive(message = "O valor deve ser positivo")
    @NotNull(message = "Campo obrigatório")
    private Integer prazoParaPagamento;

    private Boolean aprovado;

    private Long  userId;

    // Construtor que converte Proposta em PropostaDTO
    public PropostaDTO(Proposta entity) {
        id = entity.getId();
        valorSolicitado = entity.getValorSolicitado();
        prazoParaPagamento = entity.getPrazoParaPagamento();
        aprovado = entity.getAprovado();
        userId = entity.getUser().getId();
    }
}
