package com.tiendung.javaadfinalexam.service;

import com.tiendung.javaadfinalexam.entity.QuanTri;
import com.tiendung.javaadfinalexam.form.QuanTri.CreatingManagerForm;
import com.tiendung.javaadfinalexam.form.QuanTri.FilteringManagerForm;
import com.tiendung.javaadfinalexam.form.QuanTri.UpdatingManagerForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAdminService{
    Page<QuanTri> getAllAdmins(Pageable pageable, String search, FilteringManagerForm form);

    void createAdmin(CreatingManagerForm form);

    void updateAdmin(UpdatingManagerForm form);

}
