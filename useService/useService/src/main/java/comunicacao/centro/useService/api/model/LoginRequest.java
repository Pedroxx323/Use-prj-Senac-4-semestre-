package comunicacao.centro.useService.api.model;
public class LoginRequest {
 private String email;
 private String senha;
 public LoginRequest(){}
 public String getEmail(){return email;}
 public void setEmail(String v){email=v;}
 public String getSenha(){return senha;}
 public void setSenha(String v){senha=v;}
}