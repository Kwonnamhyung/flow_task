package com.example.flow.controller;

import com.example.flow.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/extension")
@RequiredArgsConstructor
public class ExtensionController {

    private final ExtensionService extensionService;
    @PostMapping("/{extensionId}")
    public void changeChecked(@PathVariable Long extensionId) {
        extensionService.changeChecked(extensionId);
    }

    @GetMapping()
    public String extension(Model model) {
        return "form/extension";
    }
}
