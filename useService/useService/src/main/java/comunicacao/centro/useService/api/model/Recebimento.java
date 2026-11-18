package comunicacao.centro.useService.api.model;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name="recebimento")
public class Recebimento {
 @Id @Column(name="codigo_recebimento",length=50) private String codigoRecebimento;
 @Column(name="id_centro",length=50,nullable=false) private String idCentro;
 @Column(name="codigo_pagamento",length=50) private String codigoPagamento;
 @Column(name="id_conta",length=50) private String idConta;
 @Column(name="origem",length=150,nullable=false) private String origem;
 @Column(name="cpf_cnpj",length=20) private String cpfCnpj;
 @Column(name="data_recebimento",nullable=false) private LocalDate dataRecebimento;
 @Column(name="valor_recebido",precision=12,scale=2,nullable=false) private BigDecimal valorRecebido;
 @Column(name="descricao",length=255) private String descricao;
 public Recebimento(){}
 public String getCodigoRecebimento(){return codigoRecebimento;}
 public void setCodigoRecebimento(String v){codigoRecebimento=v;}
 public String getIdCentro(){return idCentro;}
 public void setIdCentro(String v){idCentro=v;}
 public String getCodigoPagamento(){return codigoPagamento;}
 public void setCodigoPagamento(String v){codigoPagamento=v;}
 public String getIdConta(){return idConta;}
 public void setIdConta(String v){idConta=v;}
 public String getOrigem(){return origem;}
 public void setOrigem(String v){origem=v;}
 public String getCpfCnpj(){return cpfCnpj;}
 public void setCpfCnpj(String v){cpfCnpj=v;}
 public LocalDate getDataRecebimento(){return dataRecebimento;}
 public void setDataRecebimento(LocalDate v){dataRecebimento=v;}
 public BigDecimal getValorRecebido(){return valorRecebido;}
 public void setValorRecebido(BigDecimal v){valorRecebido=v;}
 public String getDescricao(){return descricao;}
 public void setDescricao(String v){descricao=v;}
}