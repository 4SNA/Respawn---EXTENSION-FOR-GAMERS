package com.respawn.backend.controller;

import com.respawn.backend.model.Dll;
import com.respawn.backend.service.DllService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dlls")
public class DllController {

    private final DllService dllService;

    public DllController(DllService dllService) {
        this.dllService = dllService;
    }

    @GetMapping
    public List<Dll> getDlls(@RequestParam String name) {
        return dllService.searchDlls(name);
    }

    @PostMapping
    public Dll addDll(@RequestBody Dll dll) {
        return dllService.saveDll(dll);
    }
}
