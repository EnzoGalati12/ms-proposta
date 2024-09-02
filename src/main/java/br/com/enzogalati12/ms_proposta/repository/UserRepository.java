package br.com.enzogalati12.ms_proposta.repository;

import br.com.enzogalati12.ms_proposta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
