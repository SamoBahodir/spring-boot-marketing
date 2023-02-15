//package com.example.hellospring.cor.redis;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class SettingRedisService {
//    private final SettingRedisRepository settingRedisRepository;
//
//    public void put(String key, String val) {
//        settingRedisRepository.save(new SettingRedis(key, val));
//    }
//
//    public String get(String key) {
//        Optional<SettingRedis> byId = settingRedisRepository.findById(key);
//
//        if (byId.isEmpty())
//            return null;
//
//        return byId.get().getVal();
//    }
//}
