package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Department;
import com.example.MaiLinhGroup.modal.Partner;
import com.example.MaiLinhGroup.reponsitory.PartnerReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerReponsitory partnerReponsitory;

    @Override
    public Partner updatePartner(Long recId, Partner partner) {
        Optional<Partner> optionalPartner = partnerReponsitory.findById(recId);
        if (optionalPartner.isEmpty()) {
            throw new RuntimeException("Partner not found with ID: " + recId);
        }

        Partner existingPartner = optionalPartner.get();

        if (partner.getPartnerName() != null) {
            existingPartner.setPartnerName(partner.getPartnerName());
        }
        if (partner.getUpdatedBy() != null) {
            existingPartner.setUpdatedBy(partner.getUpdatedBy());
        }
        if (partner.getIsActive() != null) {
            existingPartner.setIsActive(partner.getIsActive());
        }
        if (partner.getUpdatedBy() != null) {
            existingPartner.setUpdatedBy(partner.getUpdatedBy());
        }
        if (partner.getRecId() != null) {
            existingPartner.setRecId(partner.getRecId());
        }

        existingPartner.setUpdatedDate(LocalDateTime.now());

        return partnerReponsitory.save(existingPartner);
    }

    @Override
    public void updateActivePartner(Long recId, Boolean isactive) {
        Partner partner = partnerReponsitory.findById(recId).orElseThrow(() ->
                new RuntimeException("Partner not found with ID: " + recId));

        partner.setIsActive(isactive);
        partner.setUpdatedDate(LocalDateTime.now());
        partnerReponsitory.save(partner);
    }

    @Override
    public Partner getPartnerById(String PartnerId) {
        return partnerReponsitory.findByPartnerId(PartnerId)
                .orElseThrow(() -> new RuntimeException("Partner not found with ID: " + PartnerId));
    }


}
