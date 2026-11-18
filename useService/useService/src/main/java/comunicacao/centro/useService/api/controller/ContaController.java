package comunicacao.centro.useService.api.controller;
import comunicacao.centro.useService.api.model.Conta;
import comunicacao.centro.useService.api.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/contas")
public class ContaController {
    private final ContaService contaService;
    public ContaController(ContaService contaService) { this.contaService = contaService; }
    @GetMapping public List<Conta> listarContas() { return contaService.listarContas(); }
    @PostMapping public ResponseEntity<?> cadastrarConta(@RequestBody Conta conta) {
        try { return ResponseEntity.status(HttpStatus.CREATED).body(contaService.cadastrarConta(conta)); }
        catch (IllegalArgumentException erro) { return ResponseEntity.badRequest().body(erro.getMessage()); }
    }
    @PutMapping("/{idConta}/pagar")
    public ResponseEntity<?> pagarConta(@PathVariable String idConta) {
        try { return ResponseEntity.ok(contaService.pagarConta(idConta)); }
        catch (IllegalArgumentException erro) { return ResponseEntity.badRequest().body(erro.getMessage()); }
    }
    @PutMapping("/verificar-vencimentos")
    public ResponseEntity<List<Conta>> verificarVencimentos() {
        return ResponseEntity.ok(contaService.atualizarContasVencidas());
    }
}