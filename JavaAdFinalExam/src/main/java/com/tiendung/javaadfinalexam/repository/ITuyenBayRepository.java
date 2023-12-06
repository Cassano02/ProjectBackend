package com.tiendung.javaadfinalexam.repository;

import com.tiendung.javaadfinalexam.entity.TuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ITuyenBayRepository extends JpaRepository<TuyenBay, Integer>, JpaSpecificationExecutor<TuyenBay> {
    @Modifying
    @Transactional
    @Query("DELETE FROM TuyenBay WHERE id IN(:ids)")
    void deleteByIds(@Param("ids")List<Integer> ids);

    boolean existsByFromCity(String from);

    boolean existsByToCity(String to);
}
