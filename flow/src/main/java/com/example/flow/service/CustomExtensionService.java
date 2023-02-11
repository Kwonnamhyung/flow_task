package com.example.flow.service;

import com.example.flow.domain.CustomExtension;
import com.example.flow.domain.CustomExtensionDTO;
import com.example.flow.repository.CustomExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Service
@RequiredArgsConstructor
public class CustomExtensionService {

    private final CustomExtensionRepository customExtensionRepository;


    public void createCustomExtension(CustomExtensionDTO request , BindingResult bindingResult){

        if(request.getName().equals("")){
            bindingResult.addError(new ObjectError("name","확장자를 입력해주세요."));
            return;
        }

        boolean exists = customExtensionRepository.existsByName(request.getName());

        if(exists) {
            bindingResult.addError(new ObjectError("name","이미 등록된 확장자 입니다."));
        }else {
            CustomExtension customExtension = CustomExtension.toEntity(request);
            customExtensionRepository.save(customExtension);
        }

    }
}
