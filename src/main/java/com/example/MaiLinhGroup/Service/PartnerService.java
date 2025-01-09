package com.example.MaiLinhGroup.Service;

import com.example.MaiLinhGroup.modal.Department;
import com.example.MaiLinhGroup.modal.Partner;

public interface PartnerService {

    Partner updatePartner(Long recId, Partner partner);

    void updateActivePartner(Long recId, Boolean isactive);

    Partner getPartnerById(String PartnerId);
}
