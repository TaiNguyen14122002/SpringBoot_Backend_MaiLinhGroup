package com.example.MaiLinhGroup.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Cat_Department", schema = "dbo")
@Data
public class Department {

    @Id
    @Column(name = "DepartmentId")
    @JsonProperty("departmentId")
    private String departmentId;


    @Column(name = "RecID", updatable = false)
    @JsonProperty("recId")
    private Long recId;

    @Column(name = "DepartmentName")
    @JsonProperty("departmentName")
    private String departmentName;

    @Column(name = "IsActive")
    @JsonProperty("isActive")
    private Boolean isActive;

    @Column(name = "CreatedDate")
    @JsonProperty("createdDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Định dạng ngày tháng
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy")
    @JsonProperty("createdBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    @JsonProperty("updatedDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Định dạng ngày tháng
    private LocalDateTime updatedDate;

    @Column(name = "UpdatedBy")
    @JsonProperty("updatedBy")
    private String updatedBy;



}
