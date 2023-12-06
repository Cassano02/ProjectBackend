package com.tiendung.javaadfinalexam.service;

import com.tiendung.javaadfinalexam.entity.Staff;
import com.tiendung.javaadfinalexam.form.Staff.FilteringStaffForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IStaffService extends UserDetailsService {
    Page<Staff> getAllStaff(Pageable pageable, String search, FilteringStaffForm form);

    Staff getStaffByUserName(String userName);

    void deleteStaffs(List<Integer> ids);

    void deleteStaff(int id);
}
