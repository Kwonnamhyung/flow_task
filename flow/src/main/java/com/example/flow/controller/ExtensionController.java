package com.example.flow.controller;

import com.example.flow.domain.CustomExtension;
import com.example.flow.domain.CustomExtensionDTO;
import com.example.flow.domain.Extension;
import com.example.flow.service.CustomExtensionService;
import com.example.flow.service.ExtensionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/extension")
@RequiredArgsConstructor
@Slf4j
public class ExtensionController {

    private final ExtensionService extensionService;
    private final CustomExtensionService customExtensionService;

    @GetMapping()
    public String extension(Model model) {
        System.out.println("ExtensionController.extension");

        addAttributeExtension(model);
        addAttributeCustomExtension(model);
        model.addAttribute("customExtensionDTO" , new CustomExtensionDTO());
        return "form/extension";

    }
    @PostMapping()
    public String changeChecked(@RequestParam(value="result")String name, Model model){

        extensionService.changeChecked(name);

        addAttributeExtension(model);
        addAttributeCustomExtension(model);

        return "form/extension";
    }

    @PostMapping("customExtension")
    public String createCustomExtension(@ModelAttribute CustomExtensionDTO customExtensionDTO , BindingResult bindingResult , Model model){

        customExtensionService.createCustomExtension(customExtensionDTO , bindingResult);
        if(bindingResult.hasErrors()){
            addAttributeExtension(model);
            addAttributeCustomExtension(model);
            model.addAttribute("customExtensionDTO" , customExtensionDTO);
            return "form/extension";
        }

        return "redirect:";
    }

    @GetMapping("customExtension")
    public String deleteCustomExtension(@RequestParam(value="result")String name , Model model){
        customExtensionService.deleteCustomExtension(name);
        return "redirect:";
    }

    private void addAttributeExtension(Model model) {
        List<Extension> extensionList = extensionService.getExtensionList();

        model.addAttribute("extensionList" , extensionList);
    }

    private void addAttributeCustomExtension(Model model) {
        List<CustomExtension> customExtensionList = customExtensionService.getCustomExtensionList();
        model.addAttribute("customExtensionList" , customExtensionList);
    }
}
