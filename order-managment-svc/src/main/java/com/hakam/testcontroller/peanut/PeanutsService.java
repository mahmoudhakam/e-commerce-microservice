package com.hakam.testcontroller.peanut;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeanutsService {

    private final PeanutsRepository repository;

    @Cacheable(value = "peanuts", key = "#id")
    public Peanuts getPeanutsById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @CachePut(value = "peanuts", key = "#peanuts.id")
    public Peanuts savePeanuts(Peanuts peanuts) {
        return repository.save(peanuts);
    }
}
