package comunicacao.centro.useService.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    // Endpoint temporário para testar a API
    @GetMapping("/api/auth/teste")
    public String testarApi() {
        return "API da USE funcionando!";
    }
}