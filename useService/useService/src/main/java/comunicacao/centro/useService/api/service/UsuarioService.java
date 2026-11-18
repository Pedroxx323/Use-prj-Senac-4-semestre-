package comunicacao.centro.useService.api.service;
import comunicacao.centro.useService.api.model.Usuario;
import comunicacao.centro.useService.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {
 private final UsuarioRepository usuarioRepository;
 public UsuarioService(UsuarioRepository usuarioRepository){this.usuarioRepository=usuarioRepository;}
 public List<Usuario> listarUsuarios(){return usuarioRepository.findAll();}
 public Optional<Usuario> cadastrarUsuario(Usuario usuario){
  if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) return Optional.empty();
  return Optional.of(usuarioRepository.save(usuario));
 }
}