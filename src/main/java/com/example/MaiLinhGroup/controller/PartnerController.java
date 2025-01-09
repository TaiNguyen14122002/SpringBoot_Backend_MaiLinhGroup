package com.example.MaiLinhGroup.controller;

import com.example.MaiLinhGroup.Service.PartnerService;
import com.example.MaiLinhGroup.modal.Department;
import com.example.MaiLinhGroup.modal.Partner;
import com.example.MaiLinhGroup.reponsitory.PartnerReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partner")
public class PartnerController {

    @Autowired
    private PartnerReponsitory partnerReponsitory;

    @Autowired
    private PartnerService partnerService;

    @GetMapping()
    public List<Partner> getListPartner(){
        return partnerReponsitory.findAll();
    }

    //    @PostMapping("/adđepảtment")
//    public ResponseEntity<Branch> addBranch(@RequestBody Branch branch){
//        Branch newBranch = branchService.addBranch(branch);
//        return ResponseEntity.ok(newBranch);
//    }

    @PutMapping("/{recId}")
    public ResponseEntity<Partner> updatePartner(@PathVariable Long recId, @RequestBody Partner partner) {
        Partner updatedPartner = partnerService.updatePartner(recId, partner);
        return ResponseEntity.ok(updatedPartner);
    }

    @PutMapping("/{recId}/Deleted")
    public ResponseEntity<String> deletePartner(@PathVariable Long recId, @RequestParam boolean isActive) {
        try {
            partnerService.updateActivePartner(recId, isActive);
            return ResponseEntity.ok("Partner active status updated successfully.");
        }catch(RuntimeException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{partnerId}")
    public Partner getPartnerByPartnerId(@PathVariable String partnerId) {
        return partnerService.getPartnerById(partnerId);
    }




}
