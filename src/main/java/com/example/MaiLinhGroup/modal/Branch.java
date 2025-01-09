package com.example.MaiLinhGroup.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Cat_Branch", schema = "dbo")
@DynamicInsert // Bỏ qua các cột null khi insert
@Data
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecID", updatable = false)
    @JsonProperty("recId")
    private Long recId;


    @Column(name = "BranchId", unique = true) // Cho phép null ban đầu
    @JsonProperty("branchId")
    private String branchId;

    @Column(name = "BranchName")
    @JsonProperty("branchName")
    private String branchName;

    @Column(name = "ZoneID")
    @JsonProperty("zoneId")
    private Long zoneId;

    @Column(name = "IsActive")
    @JsonProperty("isActive")
    private Boolean isActive;

    @Column(name = "CreatedDate", updatable = false)
    @JsonProperty("createdDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy", updatable = false)
    @JsonProperty("createdBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    @JsonProperty("updatedDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedDate;

    @Column(name = "UpdatedBy")
    @JsonProperty("updatedBy")
    private String updatedBy;
}
