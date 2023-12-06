package com.tiendung.javaadfinalexam.service;


import com.tiendung.javaadfinalexam.entity.ChuyenBay;
import com.tiendung.javaadfinalexam.form.ChuyenBay.CreatingFlightForm;
import com.tiendung.javaadfinalexam.form.ChuyenBay.FilteringFlightForm;
import com.tiendung.javaadfinalexam.form.ChuyenBay.UpdatingFlightForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IChuyenBayService {
    Page<ChuyenBay> getAllChuyenBay(Pageable pageable, String search, FilteringFlightForm form);

    void deleteChuyenBays(List<Integer> ids);

    void deleteFlight(int id);

    void createChuyenBay(CreatingFlightForm form);

    void updateChuyenBay(UpdatingFlightForm form);
}
