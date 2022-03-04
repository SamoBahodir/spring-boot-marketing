package com.example.hellospring.hodim;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class HodimResource {
    private final HodimService hodimService;

    public HodimResource(HodimService hodimService) {
        this.hodimService = hodimService;
    }

    @PostMapping("/hodim")
    public ResponseEntity create(@RequestBody Hodim hodim) {
        log.info("Request save malumotlari keldi {}", hodim);
        Hodim hodim1 = hodimService.save(hodim);
        log.info("Request malumotlari qaytdi {} ", hodim1);
        return ResponseEntity.ok(hodim1);
    }

    @GetMapping("/hodim")
    public ResponseEntity getAll() {
        List<Hodim> list = hodimService.findAll();
        log.info("Malumot Keldi {}", list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/hodim1/{name}")
    public ResponseEntity findByName(@RequestParam String name){
       List< Hodim> hodim=  hodimService.findByName(name);
        return ResponseEntity.ok(hodim);
    }
    @GetMapping("/employee/all")
    public ResponseEntity permitAll() {
        List<Hodim> list = hodimService.findAll();
        log.info("Malumotga ruhsat soralmeydi {}", list);
        return ResponseEntity.ok(list);
    }
}
