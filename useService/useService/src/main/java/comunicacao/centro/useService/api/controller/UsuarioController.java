package comunicacao.centro.useService.api.controller;
import comunicacao.centro.useService.api.model.Usuario;
import comunicacao.centro.useService.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) { this.usuarioService = usuarioService; }
    @GetMapping public List<Usuario> listarUsuarios() { return usuarioService.listarUsuarios(); }
    @PostMapping public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario)
            .map(salvo -> ResponseEntity.status(HttpStatus.CREATED).body(salvo))
            .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}