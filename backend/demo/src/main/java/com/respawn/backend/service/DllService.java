package com.respawn.backend.service;

import com.respawn.backend.model.Dll;
import com.respawn.backend.repository.DllRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DllService {

    private final DllRepository repository;

    public DllService(DllRepository repository) {
        this.repository = repository;
    }

    @Cacheable(value = "dlls", key = "#name")
    public List<Dll> searchDlls(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Dll saveDll(Dll dll) {
        return repository.save(dll);
    }
}
