package com.example.flow.repository;

import com.example.flow.domain.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension , Long> {

    boolean existsByName(String name);
    void deleteByName(String name);
}
