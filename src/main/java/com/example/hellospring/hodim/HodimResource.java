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
    @PostMapping("/hodim1")
    public ResponseEntity  create(@RequestBody Hodim hodim){
        log.info("Request save malumotlari keldi {}",hodim);
        Hodim hodim1=hodimService.save(hodim);
        log.info("Request malumotlari qaytdi {} ",hodim1);
        return ResponseEntity.ok(hodim1);
    }
    @GetMapping("/hodim")
    public ResponseEntity getAll(){
        List<Hodim> list=hodimService.findAll();
        log.info("Malumot Keldi {}",list);
        return ResponseEntity.ok(list);
    }
//    @GetMapping("/hodim/{name}")
//    public ResponseEntity getAll(@PathVariable String name){
//        log.info("malumotni oldim {}",name);
//        List<Hodim> list=hodimService.findByName(name);
//        return ResponseEntity.ok(list);
//    }
}
