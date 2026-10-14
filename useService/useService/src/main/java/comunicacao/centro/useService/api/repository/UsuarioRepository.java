package comunicacao.centro.useService.api.repository;

import comunicacao.centro.useService.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository
        extends JpaRepository<Usuario, String> {

    // Busca um usuário pelo endereço de e-mail
    Optional<Usuario> findByEmail(String email);

}
