package com.tiendung.javaadfinalexam.service;

import com.tiendung.javaadfinalexam.entity.ChuyenBay;
import com.tiendung.javaadfinalexam.entity.PhiCong;
import com.tiendung.javaadfinalexam.entity.Staff;
import com.tiendung.javaadfinalexam.form.Staff.FilteringStaffForm;
import com.tiendung.javaadfinalexam.repository.IPhiCongRepository;
import com.tiendung.javaadfinalexam.repository.IQuanTriRepository;
import com.tiendung.javaadfinalexam.repository.IStaffRepository;
import com.tiendung.javaadfinalexam.specification.Staff.StaffSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class StaffService implements IStaffService{
    @Autowired
    private IStaffRepository repository;

    @Autowired
    private IPhiCongRepository phiCongRepository;

    @Autowired
    private IQuanTriRepository adminRepository;

    @Override
    public Page<Staff> getAllStaff(Pageable pageable, String search, FilteringStaffForm form) {
        Specification<Staff> where = StaffSpecification.buildWhere(search, form);
        return repository.findAll(where,pageable);
    }

    @Override
    public Staff getStaffByUserName(String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public void deleteStaffs(List<Integer> ids) {
        List<Staff> staffs = repository.findAllById(ids);
        for (Staff staff: staffs) {
            if(staff.getRole().equals("PILOT")){
                PhiCong pilot = phiCongRepository.findById(staff.getId()).get();
                for (ChuyenBay flight: pilot.getFlights()) {
                    flight.setPhiCong(null);
                }
            }
        }
        repository.deleteStaffs(ids);
    }

    @Override
    public void deleteStaff(int id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Staff staff = repository.findByUsername(username);

        if (staff == null) {
            throw new UsernameNotFoundException(username);
        }

        return new User(
                staff.getUsername(),
                staff.getPassword(),
//                Collections.emptyList()
//                //get ra role cua staff
                AuthorityUtils.createAuthorityList(staff.getRole().toString())
        );
    }
}
