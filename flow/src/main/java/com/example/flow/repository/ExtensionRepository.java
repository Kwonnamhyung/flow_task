package com.example.flow.repository;

import com.example.flow.domain.Extension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExtensionRepository extends JpaRepository<Extension , Long> {

    public Extension findByName(String name);
}
