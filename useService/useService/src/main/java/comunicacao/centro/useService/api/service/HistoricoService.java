package comunicacao.centro.useService.api.service;
import comunicacao.centro.useService.api.model.Conta;
import comunicacao.centro.useService.api.model.Recebimento;
import comunicacao.centro.useService.api.model.TransacaoHistorico;
import comunicacao.centro.useService.api.repository.ContaRepository;
import comunicacao.centro.useService.api.repository.RecebimentoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@Service
public class HistoricoService {
 private final ContaRepository contaRepository;
 private final RecebimentoRepository recebimentoRepository;
 public HistoricoService(ContaRepository contaRepository,RecebimentoRepository recebimentoRepository){
  this.contaRepository=contaRepository;this.recebimentoRepository=recebimentoRepository;
 }
 public List<TransacaoHistorico> listarHistorico(){
  List<TransacaoHistorico> historico=new ArrayList<>();
  for(Recebimento recebimento:recebimentoRepository.findAll()){
   historico.add(new TransacaoHistorico(recebimento.getDataRecebimento(),"ENTRADA",
     recebimento.getIdCentro(),recebimento.getDescricao()!=null?recebimento.getDescricao():recebimento.getOrigem(),
     recebimento.getValorRecebido()));
  }
  for(Conta conta:contaRepository.findAll()){
   if("PAGO".equals(conta.getStatus())&&conta.getDataPagamento()!=null){
    historico.add(new TransacaoHistorico(conta.getDataPagamento(),"SAIDA",conta.getIdCentro(),
     conta.getCodigoPagamento(),conta.getValor().negate()));
   }
  }
  historico.sort(Comparator.comparing(TransacaoHistorico::data).reversed());
  return historico;
 }
 public List<TransacaoHistorico> filtrarHistorico(String idCentro,LocalDate dataInicio,LocalDate dataFim){
  if(dataInicio!=null&&dataFim!=null&&dataInicio.isAfter(dataFim))
   throw new IllegalArgumentException("A data inicial não pode ser posterior à data final.");
  return listarHistorico().stream()
   .filter(transacao->idCentro==null||idCentro.equals(transacao.idCentro()))
   .filter(transacao->dataInicio==null||!transacao.data().isBefore(dataInicio))
   .filter(transacao->dataFim==null||!transacao.data().isAfter(dataFim)).toList();
 }
}