package comunicacao.centro.useService.api.controller;
import comunicacao.centro.useService.api.model.Recebimento;
import comunicacao.centro.useService.api.service.RecebimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/recebimentos")
public class RecebimentoController {
    private final RecebimentoService recebimentoService;
    public RecebimentoController(RecebimentoService recebimentoService) { this.recebimentoService = recebimentoService; }
    @GetMapping public List<Recebimento> listarRecebimentos() { return recebimentoService.listarRecebimentos(); }
    @PostMapping public ResponseEntity<?> cadastrarRecebimento(@RequestBody Recebimento recebimento) {
        try { return ResponseEntity.status(HttpStatus.CREATED).body(recebimentoService.cadastrarRecebimento(recebimento)); }
        catch (IllegalArgumentException erro) { return ResponseEntity.badRequest().body(erro.getMessage()); }
    }
}