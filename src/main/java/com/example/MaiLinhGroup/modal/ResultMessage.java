package com.example.MaiLinhGroup.modal;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
@Table(name = "tb_Tra_ResultMessage", schema = "dbo")
@Entity
public class ResultMessage {

    @Id
    @Column(name = "SMSId")  // Đặt SMSId là khóa chính
    private String smsId;

    @OneToOne
    @JoinColumn(name = "SMSId", referencedColumnName = "SMSId", insertable = false, updatable = false)
    private Message message;

    @Column(name = "RecID")
    private Long recID;

    @Column(name = "OTT")
    private String ott;

    @Column(name = "OTTStatus")
    private String ottStatus;

    @Column(name = "OTTErorrCode")
    private String ottErrorCode;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "UpdatedDate")
    private LocalDateTime updatedDate;

    @Column(name = "UpdatedBy")
    private String updatedBy;

    @Column(name = "SMSErorrCode")
    private String smsErrorCode;

    @Column(name = "SMSStatus")
    private String smsStatus;
}
