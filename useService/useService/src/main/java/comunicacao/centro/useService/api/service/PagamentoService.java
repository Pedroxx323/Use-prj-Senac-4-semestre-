package comunicacao.centro.useService.api.service;
import comunicacao.centro.useService.api.model.Pagamento;
import comunicacao.centro.useService.api.repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PagamentoService {
 private final PagamentoRepository pagamentoRepository;
 public PagamentoService(PagamentoRepository pagamentoRepository){this.pagamentoRepository=pagamentoRepository;}
 public List<Pagamento> listarPagamentos(){return pagamentoRepository.findAll();}
 public Pagamento cadastrarPagamento(Pagamento pagamento){
  if(pagamentoRepository.existsById(pagamento.getCodigoPagamento()))
   throw new IllegalArgumentException("Já existe um pagamento com esse código.");
  return pagamentoRepository.save(pagamento);
 }
}