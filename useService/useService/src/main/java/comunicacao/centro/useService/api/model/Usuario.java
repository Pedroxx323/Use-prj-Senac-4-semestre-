package comunicacao.centro.useService.api.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity @Table(name="USUARIO")
public class Usuario {
 @Id @Column(name="id_usuario",length=50,nullable=false) private String idUsuario;
 @Column(name="nome",length=150,nullable=false) private String nome;
 @Column(name="email",length=150,nullable=false,unique=true) private String email;
 @Column(name="senha",length=255,nullable=false) private String senha;
 @Column(name="data_cadastro",nullable=false) private LocalDate dataCadastro;
 public Usuario(){}
 public String getIdUsuario(){return idUsuario;}
 public void setIdUsuario(String v){idUsuario=v;}
 public String getNome(){return nome;}
 public void setNome(String v){nome=v;}
 public String getEmail(){return email;}
 public void setEmail(String v){email=v;}
 public String getSenha(){return senha;}
 public void setSenha(String v){senha=v;}
 public LocalDate getDataCadastro(){return dataCadastro;}
 public void setDataCadastro(LocalDate v){dataCadastro=v;}
}