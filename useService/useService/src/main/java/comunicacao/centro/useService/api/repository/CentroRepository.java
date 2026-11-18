package comunicacao.centro.useService.api.repository;
import comunicacao.centro.useService.api.model.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CentroRepository extends JpaRepository<Centro,String> {
 List<Centro> findByIdUsuario(String idUsuario);
}