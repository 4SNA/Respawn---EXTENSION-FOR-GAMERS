package com.respawn.backend.repository;

import com.respawn.backend.model.Dll;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DllRepository extends MongoRepository<Dll, String> {
    List<Dll> findByNameContainingIgnoreCase(String name);
}
