package br.com.enzogalati12.ms_proposta.repository;

import br.com.enzogalati12.ms_proposta.model.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropostaRepository extends JpaRepository<Proposta,Long> {
}
