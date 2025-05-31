package rbgord.com.dieta.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rbgord.com.dieta.model.Dieta;
import rbgord.com.dieta.service.DietaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/dietas")
public class DietaController {

    @Autowired
    private DietaService dietaService;

    @PostMapping("/adicionar")
    public ResponseEntity<Dieta> criarDieta(@RequestBody Dieta dieta) {
        Dieta novaDieta = dietaService.adicionaDieta(dieta);

        return ResponseEntity.ok(novaDieta);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Dieta>> listarDietas() {
        List<Dieta> dietas = dietaService.listDieta();
        return ResponseEntity.ok(dietas);
    }

    @GetMapping("/dia")
    public ResponseEntity<List<Dieta>> listarDietasPorDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia) {
        List<Dieta> dietas = dietaService.listarDietasPorDia(dia);
        return ResponseEntity.ok(dietas);
    }

}
