package com.example.flow.service;

import com.example.flow.domain.Extension;
import com.example.flow.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ExtensionService {

    private final ExtensionRepository extensionRepository;
    @Transactional
    public void changeChecked(Long extensionId) {

        Extension extension = extensionRepository.findById(extensionId).get();

        if(extension == null) {
            throw new NullPointerException();
        }else {
            extension.changeChecked();
        }

    }
}
