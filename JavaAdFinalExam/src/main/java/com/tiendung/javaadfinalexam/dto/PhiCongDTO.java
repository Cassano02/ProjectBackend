package com.tiendung.javaadfinalexam.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhiCongDTO {
    private int id;

    private String username;

    private String firstName;

    private String lastName;

    private String gender;

    private int soGioBay;
}
