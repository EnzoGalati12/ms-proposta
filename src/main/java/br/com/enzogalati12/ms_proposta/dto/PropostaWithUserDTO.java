package br.com.enzogalati12.ms_proposta.dto;


import br.com.enzogalati12.ms_proposta.model.Proposta;
import br.com.enzogalati12.ms_proposta.model.User;
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
public class PropostaWithUserDTO {

    @NotNull(message = "Campo obrigatório")
    private String nome;
    @NotNull(message = "Campo obrigatório")
    private String sobrenome;
    @NotNull(message = "Campo obrigatório")
    private String cpf;
    @NotNull(message = "Campo obrigatório")
    private String telefone;
    @NotNull(message = "Campo obrigatório")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal renda;
    @NotNull(message = "Campo obrigatório")
    private BigDecimal valorSolicitado;
    @NotNull(message = "Campo obrigatório")
    private Integer prazoParaPagamento;

    private boolean aprovado = false;


    public PropostaWithUserDTO(Proposta proposta, User user){
        nome = user.getNome();
        sobrenome = user.getSobrenome();
        cpf = user.getCpf();
        telefone = user.getTelefone();
        renda = user.getRenda();
        valorSolicitado = proposta.getValorSolicitado();
        prazoParaPagamento = proposta.getPrazoParaPagamento();
        aprovado = proposta.getAprovado();

    }

}
