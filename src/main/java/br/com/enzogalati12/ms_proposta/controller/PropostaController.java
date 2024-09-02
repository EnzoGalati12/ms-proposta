package br.com.enzogalati12.ms_proposta.controller;

import br.com.enzogalati12.ms_proposta.dto.PropostaDTO;
import br.com.enzogalati12.ms_proposta.dto.PropostaWithUserDTO;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<PropostaWithUserDTO> insert(@RequestBody @Valid PropostaWithUserDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto)
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }


}
