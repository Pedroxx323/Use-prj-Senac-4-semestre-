package comunicacao.centro.useService.api.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="conta")
public class Conta {
 @Id @Column(name="id_conta",length=50) private String idConta;
 @Column(name="id_centro",length=50,nullable=false) private String idCentro;
 @Column(name="codigo_pagamento",length=50,nullable=false) private String codigoPagamento;
 @Column(name="id_usuario",length=50,nullable=false) private String idUsuario;
 @Column(name="data_pagamento") private LocalDate dataPagamento;
 @Column(name="valor",precision=12,scale=2,nullable=false) private BigDecimal valor;
 @Column(name="status",length=30,nullable=false) private String status;
 @Column(name="data_vencimento") private LocalDate dataVencimento;
 public Conta(){}
 public String getIdConta(){return idConta;}
 public void setIdConta(String v){idConta=v;}
 public String getIdCentro(){return idCentro;}
 public void setIdCentro(String v){idCentro=v;}
 public String getCodigoPagamento(){return codigoPagamento;}
 public void setCodigoPagamento(String v){codigoPagamento=v;}
 public String getIdUsuario(){return idUsuario;}
 public void setIdUsuario(String v){idUsuario=v;}
 public LocalDate getDataPagamento(){return dataPagamento;}
 public void setDataPagamento(LocalDate v){dataPagamento=v;}
 public BigDecimal getValor(){return valor;}
 public void setValor(BigDecimal v){valor=v;}
 public String getStatus(){return status;}
 public void setStatus(String v){status=v;}
 public LocalDate getDataVencimento(){return dataVencimento;}
 public void setDataVencimento(LocalDate v){dataVencimento=v;}
}