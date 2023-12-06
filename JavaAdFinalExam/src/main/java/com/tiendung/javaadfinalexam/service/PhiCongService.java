package com.tiendung.javaadfinalexam.service;

import com.tiendung.javaadfinalexam.entity.PhiCong;
import com.tiendung.javaadfinalexam.form.PhiCong.CreatingPilotForm;
import com.tiendung.javaadfinalexam.form.PhiCong.FilteringPilotsForm;
import com.tiendung.javaadfinalexam.form.PhiCong.UpdatingPilotsForm;
import com.tiendung.javaadfinalexam.repository.IPhiCongRepository;
import com.tiendung.javaadfinalexam.specification.PhiCong.PilotSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PhiCongService implements IPhiCongService{

    @Autowired
    private IPhiCongRepository repository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<PhiCong> getAllPilot(Pageable pageable, String search, FilteringPilotsForm form) {
        Specification<PhiCong> where = PilotSpecification.buildWhere(search, form);
        return repository.findAll(where,pageable);
    }

    @Override
    public void createPilot(CreatingPilotForm form) {
        //convert from form to entity
        PhiCong pilot = modelMapper.map(form, PhiCong.class);

        repository.save(pilot);
    }

    @Override
    public void updatePilotInfo(UpdatingPilotsForm form) {
        //convert from form to entity
        PhiCong pilot = modelMapper.map(form, PhiCong.class);

        repository.save(pilot);
    }


}
