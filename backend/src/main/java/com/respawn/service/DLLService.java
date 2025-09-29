package com.respawn.service;

import com.respawn.model.DLLFile;
import com.respawn.repository.DLLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // injects final fields via constructor
public class DLLService {

  private  DLLRepository dllRepository;

  public DLLFile save(DLLFile file) {
    return dllRepository.save(file);
  }

  public List<DLLFile> findAll() {
    return dllRepository.findAll();
  }

  public Optional<DLLFile> findById(String id) {
    return dllRepository.findById(id);
  }

  public void deleteById(String id) {
    dllRepository.deleteById(id);
  }
}



