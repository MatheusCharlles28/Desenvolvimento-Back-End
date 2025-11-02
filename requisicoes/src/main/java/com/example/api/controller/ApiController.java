package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/saudacao")
    public ResponseEntity<String> saudacao(@RequestParam String nome){
        return ResponseEntity.ok("Olá, " + nome + "!");
    }
    @GetMapping("/agora")
    public ResponseEntity<String> agora(){
        return ResponseEntity.ok(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Map<String,Object>> usuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(Map.of("id",id,"nome","Usuário "+id));
    }
    @GetMapping("/usuarios")
    public ResponseEntity<List<Map<String,Object>>> usuariosPorNome(@RequestParam String nome){
        List<Map<String,Object>> lista=new ArrayList<>();
        lista.add(Map.of("id",1,"nome",nome+" Silva"));
        lista.add(Map.of("id",2,"nome",nome+" Souza"));
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/curtidas")
    public ResponseEntity<Map<String,Long>> curtidas(@RequestParam Long userId){
        return ResponseEntity.ok(Map.of("userId",userId,"likes",userId*3));
    }
    @GetMapping("/soma")
    public ResponseEntity<Map<String,Double>> soma(@RequestParam double a,@RequestParam double b){
        return ResponseEntity.ok(Map.of("resultado",a+b));
    }
    @GetMapping("/fatorial/{n}")
    public ResponseEntity<Map<String,Long>> fatorial(@PathVariable int n){
        long r=1;for(int i=2;i<=n;i++)r*=i;
        return ResponseEntity.ok(Map.of("n", (long)n, "fatorial",r));
    }
    @GetMapping("/boletim/{id}")
    public ResponseEntity<Map<String,Object>> boletim(@PathVariable Long id){
        List<Double> notas=Arrays.asList(7.5,8.0,6.5);
        double media=notas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        return ResponseEntity.ok(Map.of("alunoId",id,"notas",notas,"media",media));
    }
    @GetMapping("/produto-caro")
    public ResponseEntity<Map<String,Object>> produtoCaro(@RequestParam String categoria){
        return ResponseEntity.ok(Map.of("categoria",categoria,"produto","Produto X","preco",199.99));
    }
    @GetMapping("/estatisticas")
    public ResponseEntity<Map<String,Object>> estatisticas(@RequestParam String time){
        return ResponseEntity.ok(Map.of("time",time,"vitorias",12,"derrotas",5));
    }
}
