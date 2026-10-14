package comunicacao.centro.useService.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private String idUsuario;

    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }
}
