package comunicacao.centro.useService.api.service;
import comunicacao.centro.useService.api.model.Centro;
import comunicacao.centro.useService.api.repository.CentroRepository;
import comunicacao.centro.useService.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class CentroService {
 private final CentroRepository centroRepository;
 private final UsuarioRepository usuarioRepository;
 public CentroService(CentroRepository centroRepository, UsuarioRepository usuarioRepository) {
  this.centroRepository=centroRepository; this.usuarioRepository=usuarioRepository;
 }
 public List<Centro> listarCentros(){return centroRepository.findAll();}
 public Optional<Centro> buscarPorId(String idCentro){return centroRepository.findById(idCentro);}
 public Centro cadastrarCentro(Centro centro){
  if(!usuarioRepository.existsById(centro.getIdUsuario())) throw new IllegalArgumentException("O usuário responsável não existe.");
  return centroRepository.save(centro);
 }
}