package br.com.enzogalati12.ms_proposta.service;


import br.com.enzogalati12.ms_proposta.dto.PropostaDTO;
import br.com.enzogalati12.ms_proposta.dto.PropostaWithUserDTO;
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

    //insert
    @Transactional
    public PropostaWithUserDTO insert(PropostaWithUserDTO dto) {
        User user = new User();
        Proposta proposta = new Proposta();
        copyDtoToEntity(dto, proposta, user);
        user = userRepository.save(user);
        proposta.setUser(user);
        proposta = repository.save(proposta);
        return new PropostaWithUserDTO(proposta, user);
    }




    private void copyDtoToEntity(PropostaWithUserDTO dto, Proposta proposta, User user) {
        proposta.setValorSolicitado(dto.getValorSolicitado());
        proposta.setPrazoParaPagamento(dto.getPrazoParaPagamento());
        proposta.setAprovado(dto.isAprovado());
        user.setNome(dto.getNome());
        user.setSobrenome(dto.getSobrenome());
        user.setCpf(dto.getCpf());
        user.setTelefone(dto.getTelefone());
        user.setRenda(dto.getRenda());
    }

}
