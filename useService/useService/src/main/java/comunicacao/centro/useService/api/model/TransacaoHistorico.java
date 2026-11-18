package comunicacao.centro.useService.api.model;
import java.math.BigDecimal;
import java.time.LocalDate;
public record TransacaoHistorico(LocalDate data,String tipo,String idCentro,String descricao,BigDecimal valor) {}