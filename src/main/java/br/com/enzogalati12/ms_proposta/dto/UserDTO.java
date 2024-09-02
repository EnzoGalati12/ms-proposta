package br.com.enzogalati12.ms_proposta.dto;

import br.com.enzogalati12.ms_proposta.model.Proposta;
import br.com.enzogalati12.ms_proposta.model.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;

    @NotNull(message = "Campo obrigatório")
    @Size(max = 100, message = "Máximo de 100 caracteres")
    private String nome;

    @Size(max = 100, message = "Máximo de 100 caracteres")
    @NotNull(message = "Campo obrigatório")
    private String sobrenome;

    @NotNull(message = "Campo obrigatório")
    private String cpf;

    @NotNull(message = "Campo obrigatório")
    private String telefone;

    @NotNull(message = "Campo obrigatório")
    private BigDecimal renda;

    private List<PropostaDTO> propostas = new ArrayList<>();

    // Construtor que converte User em UserDTO
    public UserDTO(User entity) {
        id = entity.getId();
        nome = entity.getNome();
        sobrenome = entity.getSobrenome();
        cpf = entity.getCpf();
        telefone = entity.getTelefone();
        renda = entity.getRenda();

        // Converte a lista de Propostas em PropostaDTO
       //propostas = entity.getPropostas().stream().map(PropostaDTO::new).collect(Collectors.toList());
    }
}
