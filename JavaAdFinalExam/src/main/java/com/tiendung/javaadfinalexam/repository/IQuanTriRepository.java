package com.tiendung.javaadfinalexam.repository;

import com.tiendung.javaadfinalexam.entity.QuanTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IQuanTriRepository extends JpaRepository<QuanTri,Integer>, JpaSpecificationExecutor<QuanTri> {

}
