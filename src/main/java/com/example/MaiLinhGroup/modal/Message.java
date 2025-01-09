package com.example.MaiLinhGroup.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_Tra_Message", schema = "dbo")
@Data
public class Message {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecID")
    private Long recID;

    @Id
    @Column(name = "SMSId")
    private String smsId;

    @Column(name = "RequestId")
    private String requestId;

    @ManyToOne
    @JoinColumn(name = "PartnerId", referencedColumnName = "PartnerId")
    private Partner partner;

    @ManyToOne
    @JoinColumn(name = "BranchId", referencedColumnName = "BranchId")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "DepartmentId", referencedColumnName = "DepartmentId")
    private Department department;

    @Column(name = "FromId")
    private String fromId;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "TemplateId")
    private String templateId;

    @Column(name = "TemplateData")
    private String templateData;

    @Column(name = "SMSData")
    private String smsData;

    @Column(name = "SMSUnicode")
    private Boolean smsUnicode;

    @Column(name = "Status")
    private String status;

    @Column(name = "TrackingId")
    private String trackingId;

    @Column(name = "ErrorCode")
    private String errorCode;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    private LocalDateTime updatedDate;

    @Column(name = "UpdatedBy")
    private String updatedBy;

}
