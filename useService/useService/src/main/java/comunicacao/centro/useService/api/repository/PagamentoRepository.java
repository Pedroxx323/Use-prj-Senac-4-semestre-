package comunicacao.centro.useService.api.repository;
import comunicacao.centro.useService.api.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PagamentoRepository extends JpaRepository<Pagamento,String> {}