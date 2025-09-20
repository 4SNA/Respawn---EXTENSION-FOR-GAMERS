package com.respawn.backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dlls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dll {
    @Id
    private String id;
    private String name;
    private String version;
    private String downloadUrl;
    private String checksum;
}
