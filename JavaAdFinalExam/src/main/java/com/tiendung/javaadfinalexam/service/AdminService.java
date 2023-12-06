package com.tiendung.javaadfinalexam.service;

import com.tiendung.javaadfinalexam.entity.QuanTri;
import com.tiendung.javaadfinalexam.form.QuanTri.CreatingManagerForm;
import com.tiendung.javaadfinalexam.form.QuanTri.FilteringManagerForm;
import com.tiendung.javaadfinalexam.form.QuanTri.UpdatingManagerForm;
import com.tiendung.javaadfinalexam.repository.IQuanTriRepository;
import com.tiendung.javaadfinalexam.specification.QuanLy.AdminSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements IAdminService{

    @Autowired
    private IQuanTriRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<QuanTri> getAllAdmins(Pageable pageable, String search, FilteringManagerForm form) {
        Specification<QuanTri> where = AdminSpecification.buildWhere(search,form);
        return repository.findAll(where,pageable);
    }

    @Override
    public void createAdmin(CreatingManagerForm form) {
        // convert form to entity
        QuanTri manager = modelMapper.map(form, QuanTri.class);

        repository.save(manager);

    }

    @Override
    public void updateAdmin(UpdatingManagerForm form) {
        //convert to entity
        QuanTri manager = modelMapper.map(form,QuanTri.class);
        repository.save(manager);
    }
}
