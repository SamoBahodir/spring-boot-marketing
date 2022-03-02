package com.example.hellospring.hodim;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HodimResource {
    private final HodimService hodimService;

    public HodimResource(HodimService hodimService) {
        this.hodimService = hodimService;
    }
    @PostMapping("/hodim")
    public ResponseEntity  create(@RequestBody Hodim hodim){
        Hodim hodim1=hodimService.save(hodim);
        return ResponseEntity.ok(hodim1);
    }
    @GetMapping("/hodim")
    public ResponseEntity getAll(){
        List<Hodim> list=hodimService.findAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/hodim/{name}")
    public ResponseEntity getAll(@PathVariable String name){
        List<Hodim> list=hodimService.findByName(name);
        return ResponseEntity.ok(list);
    }
}
