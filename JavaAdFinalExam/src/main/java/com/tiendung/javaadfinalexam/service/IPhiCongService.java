package com.tiendung.javaadfinalexam.service;

import com.tiendung.javaadfinalexam.entity.PhiCong;
import com.tiendung.javaadfinalexam.form.PhiCong.CreatingPilotForm;
import com.tiendung.javaadfinalexam.form.PhiCong.FilteringPilotsForm;
import com.tiendung.javaadfinalexam.form.PhiCong.UpdatingPilotsForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPhiCongService {
    public Page<PhiCong> getAllPilot(Pageable pageable, String search, FilteringPilotsForm form);

    void createPilot(CreatingPilotForm form);

    void updatePilotInfo(UpdatingPilotsForm form);
}
