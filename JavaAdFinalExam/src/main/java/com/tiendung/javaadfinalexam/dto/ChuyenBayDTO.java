package com.tiendung.javaadfinalexam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ChuyenBayDTO {
    private int id;

    private int tuyenBayId;

    private String type;

    @JsonProperty("CoTruong")
    private String PhiCongFullName;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date endTime;

    @JsonProperty("fromCity")
    private String tuyenBayFromCity;

    @JsonProperty("toCity")
    private String tuyenBayToCity;
}
