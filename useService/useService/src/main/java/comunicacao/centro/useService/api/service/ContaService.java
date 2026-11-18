package comunicacao.centro.useService.api.service;
import comunicacao.centro.useService.api.model.Conta;
import comunicacao.centro.useService.api.repository.ContaRepository;
import comunicacao.centro.useService.api.repository.CentroRepository;
import comunicacao.centro.useService.api.repository.PagamentoRepository;
import comunicacao.centro.useService.api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
@Service
public class ContaService {
 private final ContaRepository contaRepository;
 private final CentroRepository centroRepository;
 private final PagamentoRepository pagamentoRepository;
 private final UsuarioRepository usuarioRepository;
 public ContaService(ContaRepository contaRepository,CentroRepository centroRepository,
    PagamentoRepository pagamentoRepository,UsuarioRepository usuarioRepository) {
  this.contaRepository=contaRepository;this.centroRepository=centroRepository;
  this.pagamentoRepository=pagamentoRepository;this.usuarioRepository=usuarioRepository;
 }
 public List<Conta> listarContas(){return contaRepository.findAll();}
 public Conta cadastrarConta(Conta conta){
  if(conta.getIdConta()==null||conta.getIdConta().isBlank()) throw new IllegalArgumentException("Informe o ID da conta.");
  if(contaRepository.existsById(conta.getIdConta())) throw new IllegalArgumentException("Já existe uma conta com esse ID.");
  if(conta.getIdCentro()==null||!centroRepository.existsById(conta.getIdCentro())) throw new IllegalArgumentException("Centro não encontrado.");
  if(conta.getCodigoPagamento()==null||!pagamentoRepository.existsById(conta.getCodigoPagamento())) throw new IllegalArgumentException("Tipo de pagamento não encontrado.");
  if(conta.getIdUsuario()==null||!usuarioRepository.existsById(conta.getIdUsuario())) throw new IllegalArgumentException("Usuário não encontrado.");
  if(conta.getValor()==null||conta.getValor().compareTo(BigDecimal.ZERO)<0) throw new IllegalArgumentException("O valor não pode ser negativo.");
  if(conta.getStatus()==null||!List.of("PENDENTE","PAGO","VENCIDO").contains(conta.getStatus()))
   throw new IllegalArgumentException("O status deve ser PENDENTE, PAGO ou VENCIDO.");
  return contaRepository.save(conta);
 }
 public Conta pagarConta(String idConta){
  Conta conta=contaRepository.findById(idConta).orElseThrow(()->new IllegalArgumentException("Conta não encontrada."));
  if("PAGO".equals(conta.getStatus())) throw new IllegalArgumentException("Esta conta já foi paga.");
  conta.setStatus("PAGO");
  conta.setDataPagamento(LocalDate.now());
  return contaRepository.save(conta);
 }
 public List<Conta> atualizarContasVencidas(){
  List<Conta> contas=contaRepository.findAll(); LocalDate hoje=LocalDate.now();
  for(Conta conta:contas){
   if("PENDENTE".equals(conta.getStatus())&&conta.getDataVencimento()!=null&&conta.getDataVencimento().isBefore(hoje)){
    conta.setStatus("VENCIDO"); contaRepository.save(conta);
   }
  }
  return contaRepository.findAll();
 }
}