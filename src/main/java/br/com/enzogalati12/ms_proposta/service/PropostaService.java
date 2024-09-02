package br.com.enzogalati12.ms_proposta.service;


import br.com.enzogalati12.ms_proposta.dto.PropostaDTO;
import br.com.enzogalati12.ms_proposta.dto.UserDTO;
import br.com.enzogalati12.ms_proposta.model.Proposta;
import br.com.enzogalati12.ms_proposta.model.User;
import br.com.enzogalati12.ms_proposta.repository.PropostaRepository;
import br.com.enzogalati12.ms_proposta.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PropostaService {

    @Autowired
    PropostaRepository repository;

    @Autowired
    UserRepository userRepository;

    //Listar propostas
    @Transactional(readOnly = true)
    public Page<PropostaDTO> findAll(Pageable pageable) {
        Page<Proposta> page = repository.findAll(pageable);
        return page.map(PropostaDTO::new);
    }

    //por id
    @Transactional(readOnly = true)
    public PropostaDTO findById(Long id) {
        Proposta entity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Recurso não encontrado"));
        return new PropostaDTO(entity);
    }

    //delete
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Recurso não encontrado");
        }
    }


    @Transactional
    public PropostaDTO insert(PropostaDTO propostaDTO, UserDTO userDTO) {
        // Busque o usuário pelo ID ou lance uma exceção se não encontrado
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        Proposta proposta = new Proposta();
        copyDtoToEntity(propostaDTO, proposta);

        // Associe o usuário à proposta
        proposta.setUser(user);

        // Salve a proposta
        proposta = repository.save(proposta);

        return new PropostaDTO(proposta);
    }

    private void copyDtoToEntity(PropostaDTO dto, Proposta entity) {

        entity.setValorSolicitado(dto.getValorSolicitado());
        entity.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        entity.setAprovado(dto.getAprovado());
    }


}
