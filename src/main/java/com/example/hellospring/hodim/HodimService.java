package com.example.hellospring.hodim;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HodimService {
    private final HodimRepository hodimRepository;

    public HodimService(HodimRepository hodimRepository) {
        this.hodimRepository = hodimRepository;
    }

    public Hodim save(Hodim hodim) {
        return hodimRepository.save(hodim);
    }

    public List<Hodim> findAll() {
        return hodimRepository.findAll();
    }

    public Hodim findById(Long id){
        return hodimRepository.findById(id).get();
    }
    public List<Hodim> findByName(String name){
        return hodimRepository.findByName(name);
    }
}
