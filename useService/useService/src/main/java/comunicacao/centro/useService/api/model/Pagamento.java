package comunicacao.centro.useService.api.model;
import jakarta.persistence.*;
@Entity @Table(name="PAGAMENTO")
public class Pagamento {
 @Id @Column(name="codigo_pagamento",length=50) private String codigoPagamento;
 @Column(name="tipo",length=100,nullable=false) private String tipo;
 @Column(name="descricao",length=255) private String descricao;
 public Pagamento(){}
 public String getCodigoPagamento(){return codigoPagamento;}
 public void setCodigoPagamento(String v){codigoPagamento=v;}
 public String getTipo(){return tipo;}
 public void setTipo(String v){tipo=v;}
 public String getDescricao(){return descricao;}
 public void setDescricao(String v){descricao=v;}
}