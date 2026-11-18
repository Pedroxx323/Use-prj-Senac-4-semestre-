package comunicacao.centro.useService.api.repository;
import comunicacao.centro.useService.api.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ContaRepository extends JpaRepository<Conta,String> {
 List<Conta> findByIdCentro(String idCentro);
}