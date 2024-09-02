package br.com.enzogalati12.ms_proposta.controller;

import br.com.enzogalati12.ms_proposta.dto.PropostaDTO;
import br.com.enzogalati12.ms_proposta.dto.UserDTO;
import br.com.enzogalati12.ms_proposta.service.PropostaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propostas")
public class PropostaController {


    @Autowired
    PropostaService service;

    //findall
    @GetMapping
    public ResponseEntity<Page<PropostaDTO>> findAll(@PageableDefault(size = 10) Pageable pageable) {

        Page<PropostaDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
    //findbyid
    @GetMapping("/{id}")
    public ResponseEntity<PropostaDTO> fingById(@PathVariable @NotNull Long id){
        PropostaDTO dto =  service.findById(id);
        return ResponseEntity.ok(dto);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    // Inserir uma nova proposta associada a um usuário
    @PostMapping
    public ResponseEntity<PropostaDTO> insert(@Valid @RequestBody PropostaDTO propostaDTO) {
        // Cria um UserDTO com o ID do usuário
        UserDTO userDTO = new UserDTO();
        userDTO.setId(propostaDTO.getUserId());
        // Chama o serviço para inserir a proposta
        PropostaDTO dto = service.insert(propostaDTO, userDTO);

        // Retorna a resposta com o status 201 Created e o corpo da nova proposta
        return ResponseEntity.status(201).body(dto);
    }


}
