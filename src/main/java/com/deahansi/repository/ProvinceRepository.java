package com.deahansi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deahansi.entity.Province;
import com.deahansi.model.ProvinceModel;

public interface ProvinceRepository extends JpaRepository<Province, String> {
    Optional<Province> findById(String id);
    // Optional<Provincel> findById(String id);
}
