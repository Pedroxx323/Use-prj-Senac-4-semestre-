package comunicacao.centro.useService.api.service;
import comunicacao.centro.useService.api.model.Recebimento;
import comunicacao.centro.useService.api.repository.CentroRepository;
import comunicacao.centro.useService.api.repository.ContaRepository;
import comunicacao.centro.useService.api.repository.PagamentoRepository;
import comunicacao.centro.useService.api.repository.RecebimentoRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
@Service
public class RecebimentoService {
 private final RecebimentoRepository recebimentoRepository;
 private final CentroRepository centroRepository;
 private final ContaRepository contaRepository;
 private final PagamentoRepository pagamentoRepository;
 public RecebimentoService(RecebimentoRepository recebimentoRepository,CentroRepository centroRepository,
  ContaRepository contaRepository,PagamentoRepository pagamentoRepository){
  this.recebimentoRepository=recebimentoRepository;this.centroRepository=centroRepository;
  this.contaRepository=contaRepository;this.pagamentoRepository=pagamentoRepository;
 }
 public List<Recebimento> listarRecebimentos(){return recebimentoRepository.findAll();}
 public Recebimento cadastrarRecebimento(Recebimento recebimento){
  if(recebimento.getCodigoRecebimento()==null||recebimento.getCodigoRecebimento().isBlank())
   throw new IllegalArgumentException("Informe o código do recebimento.");
  if(recebimentoRepository.existsById(recebimento.getCodigoRecebimento()))
   throw new IllegalArgumentException("Já existe um recebimento com esse código.");
  if(recebimento.getIdCentro()==null||!centroRepository.existsById(recebimento.getIdCentro()))
   throw new IllegalArgumentException("Centro não encontrado.");
  if(recebimento.getOrigem()==null||recebimento.getOrigem().isBlank())
   throw new IllegalArgumentException("Informe a origem do recebimento.");
  if(recebimento.getDataRecebimento()==null)
   throw new IllegalArgumentException("Informe a data do recebimento.");
  if(recebimento.getValorRecebido()==null||recebimento.getValorRecebido().compareTo(BigDecimal.ZERO)<0)
   throw new IllegalArgumentException("O valor recebido não pode ser negativo.");
  if(recebimento.getIdConta()!=null&&!contaRepository.existsById(recebimento.getIdConta()))
   throw new IllegalArgumentException("Conta não encontrada.");
  if(recebimento.getCodigoPagamento()!=null&&!pagamentoRepository.existsById(recebimento.getCodigoPagamento()))
   throw new IllegalArgumentException("Tipo de pagamento não encontrado.");
  return recebimentoRepository.save(recebimento);
 }
}