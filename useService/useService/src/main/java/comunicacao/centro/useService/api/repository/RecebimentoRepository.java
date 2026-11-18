package comunicacao.centro.useService.api.repository;
import comunicacao.centro.useService.api.model.Recebimento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RecebimentoRepository extends JpaRepository<Recebimento,String> {
 List<Recebimento> findByIdCentro(String idCentro);
}