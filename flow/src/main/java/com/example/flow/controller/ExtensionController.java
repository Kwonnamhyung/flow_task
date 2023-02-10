package com.example.flow.controller;

import com.example.flow.domain.Extension;
import com.example.flow.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/extension")
@RequiredArgsConstructor
public class ExtensionController {

    private final ExtensionService extensionService;

    @GetMapping()
    public String extension(Model model) {

        addAttributeExtension(model);

        return "form/extension";

    }
    @PostMapping()
    public String changeChecked(@RequestParam(value="result")String name, Model model){

        extensionService.changeChecked(name);

        addAttributeExtension(model);

        return "form/extension";
    }

    private void addAttributeExtension(Model model) {
        List<Extension> extensionList = extensionService.getExtensionList();

        model.addAttribute("extensionList" , extensionList);
    }
}
