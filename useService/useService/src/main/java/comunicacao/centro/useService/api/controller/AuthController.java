package comunicacao.centro.useService.api.controller;
import comunicacao.centro.useService.api.model.LoginRequest;
import comunicacao.centro.useService.api.model.Usuario;
import comunicacao.centro.useService.api.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class AuthController {
    private final UsuarioRepository usuarioRepository;
    public AuthController(UsuarioRepository usuarioRepository) { this.usuarioRepository = usuarioRepository; }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest dados) {
        Usuario usuario = usuarioRepository.findByEmail(dados.getEmail()).orElse(null);
        if (usuario == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha inválidos.");
        return ResponseEntity.ok("Usuário encontrado. Falta validar a senha.");
    }
}