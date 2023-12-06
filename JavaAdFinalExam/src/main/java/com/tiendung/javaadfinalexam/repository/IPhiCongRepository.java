package com.tiendung.javaadfinalexam.repository;

import com.tiendung.javaadfinalexam.entity.PhiCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPhiCongRepository extends JpaRepository<PhiCong,Integer>, JpaSpecificationExecutor<PhiCong> {
}
