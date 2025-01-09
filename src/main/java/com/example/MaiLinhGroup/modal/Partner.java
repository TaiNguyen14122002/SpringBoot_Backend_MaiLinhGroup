package com.example.MaiLinhGroup.modal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_Cat_Partner", schema = "dbo")
@Entity
public class Partner {



    @Column(name = "RecID")
    private Long recId;

    @Id
    @Column(name = "PartnerId")
    @JsonProperty("partnerId")  // Đảm bảo rằng trường này được chuyển thành JSON
    private String partnerId;

    @Column(name = "PartnerName")
    @JsonProperty("partnerName")
    private String partnerName;

    @Column(name = "IsActive")
    @JsonProperty("isActive")
    private Boolean isActive;

    @Column(name = "CreatedDate")
    @JsonProperty("createdDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // Định dạng ngày tháng
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy")
    @JsonProperty("createdBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    @JsonProperty("updatedDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // Định dạng ngày tháng
    private LocalDateTime updatedDate;

    @Column(name = "UpdatedBy")
    @JsonProperty("updatedBy")
    private String updatedBy;

}
