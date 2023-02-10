package com.example.flow.service;

import com.example.flow.domain.Extension;
import com.example.flow.repository.ExtensionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExtensionService {

    private final ExtensionRepository extensionRepository;
    @Transactional
    public void changeChecked(String name) {

        Extension extension = extensionRepository.findByName(name);

        if(extension == null) {
            throw new NullPointerException("찾으시는 확장자가 존재하지 않습니다.");
        }else {
            extension.changeChecked();
        }

    }

    public List<Extension> getExtensionList(){
        return extensionRepository.findAll();
    }
}
