package comunicacao.centro.useService.api.controller;
import comunicacao.centro.useService.api.service.HistoricoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
@RestController
@RequestMapping("/historico")
public class HistoricoController {
    private final HistoricoService historicoService;
    public HistoricoController(HistoricoService historicoService) { this.historicoService = historicoService; }
    @GetMapping public ResponseEntity<?> listarHistorico(
        @RequestParam(required = false) String idCentro,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
        try { return ResponseEntity.ok(historicoService.filtrarHistorico(idCentro, dataInicio, dataFim)); }
        catch (IllegalArgumentException erro) { return ResponseEntity.badRequest().body(erro.getMessage()); }
    }
}