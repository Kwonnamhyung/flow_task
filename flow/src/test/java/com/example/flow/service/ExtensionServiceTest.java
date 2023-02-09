package com.example.flow.service;

import com.example.flow.domain.Extension;
import com.example.flow.repository.ExtensionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ExtensionServiceTest {

    @InjectMocks
    ExtensionService extensionService;

    @Mock
    ExtensionRepository extensionRepository;

    @Test
    @DisplayName("고정 확장자 check 테스트")
    public void changeChecked() {

        Extension extension = Extension.builder()
                .id(10L)
                .name("bat")
                .isChecked(false)
                .build();

        given(extensionRepository.findById(10L)).willReturn(Optional.of(extension));

        extensionService.changeChecked(10L);

        Assertions.assertThat(extension.isChecked()).isEqualTo(true);

    }

}