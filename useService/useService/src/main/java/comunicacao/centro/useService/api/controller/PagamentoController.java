package comunicacao.centro.useService.api.controller;
import comunicacao.centro.useService.api.model.Pagamento;
import comunicacao.centro.useService.api.service.PagamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    private final PagamentoService pagamentoService;
    public PagamentoController(PagamentoService pagamentoService) { this.pagamentoService = pagamentoService; }
    @GetMapping public List<Pagamento> listarPagamentos() { return pagamentoService.listarPagamentos(); }
    @PostMapping public ResponseEntity<?> cadastrarPagamento(@RequestBody Pagamento pagamento) {
        try { return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.cadastrarPagamento(pagamento)); }
        catch (IllegalArgumentException erro) { return ResponseEntity.status(HttpStatus.CONFLICT).body(erro.getMessage()); }
    }
}