package com.respawn.controller;

import com.respawn.model.DLLFile;
import com.respawn.service.DLLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dll")
@RequiredArgsConstructor
public class DLLController {

  private DLLService dllService;

  @PostMapping
  public ResponseEntity<DLLFile> uploadFile(@RequestBody DLLFile file) {
    return ResponseEntity.ok(dllService.save(file));
  }

  @GetMapping
  public ResponseEntity<List<DLLFile>> getAllFiles() {
    return ResponseEntity.ok(dllService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<DLLFile> getFileById(@PathVariable String id) {
    return dllService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFile(@PathVariable String id) {
    dllService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}



