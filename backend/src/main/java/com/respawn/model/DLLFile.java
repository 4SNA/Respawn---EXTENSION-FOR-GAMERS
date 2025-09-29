package com.respawn.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dll_files")
@Data // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DLLFile {
  @Id
  private String id;
  private String fileName;
  private String filePath;
  private long fileSize;
}



