//package com.example.hellospring.cor.redis;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class TranslationRedisService {
//    private final TranslationRedisRepository translationRedisRepository;
//
//    public void save(TranslationRedis translation) {
//       translationRedisRepository.save(translation);
//    }
//
//    public void delete(String tag) {
//        translationRedisRepository.deleteById(tag);
//    }
//
//    public TranslationRedis getByTag(String tag){
//        return translationRedisRepository.findById(tag).orElse(null);
//    }
//}
