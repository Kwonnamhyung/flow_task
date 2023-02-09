package com.example.flow.controller;

import com.example.flow.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/extension")
@RequiredArgsConstructor
public class ExtensionController {

    private final ExtensionService extensionService;
    @PostMapping("/{extensionId}")
    public void changeChecked(@PathVariable Long extensionId) {
        extensionService.changeChecked(extensionId);
    }
}
