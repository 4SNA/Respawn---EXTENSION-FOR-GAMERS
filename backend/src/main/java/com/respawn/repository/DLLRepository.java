package com.respawn.repository;

import com.respawn.model.DLLFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DLLRepository extends MongoRepository<DLLFile, String> {
}



