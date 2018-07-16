package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.interfaces.IMedicineService;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.enums.MedicineTestType;
import com.nader.aria.assistant.entities.enums.MedicineType;
import com.nader.aria.assistant.entities.medicine.DrugInfo;
import com.nader.aria.assistant.entities.medicine.MedicineInfo;
import com.nader.aria.assistant.utils.ResponseEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/medicine")
public class MedicineWebService {

    private IMedicineService medicineService;

    @Autowired
    public MedicineWebService(IMedicineService medicineService){
        this.medicineService = medicineService;
    }

    @GetMapping("/getMedicineTestTypes")
    public ResponseEntity<?> getMedicineTestTypes(){

        return ResponseEntityManager.OK.getResponseEntity(MedicineTestType.values());
    }

    @GetMapping("/getMedicineTypes")
    public ResponseEntity<?> getMedicineTypes(){

        return ResponseEntityManager.OK.getResponseEntity(MedicineType.values());
    }

    @PostMapping("/addDrugInfo")
    public ResponseEntity<?> addDrugInfo(@RequestBody DrugInfo drugInfo){

        if( drugInfo != null ){
            try {
                return ResponseEntityManager.CREATED.getResponseEntity(medicineService.addDrugInfo(drugInfo));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readAllDrugInfo")
    public ResponseEntity<?> readAllDrugInfo(@RequestBody Login login){

        if( login != null && login.getId() != null ){
            try{
                return ResponseEntityManager.OK.getResponseEntity(medicineService.readAllDrugInfo(login));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readDrugInfo")
    public ResponseEntity<?> readDrugInfo(@RequestBody Long drugInfoId){

        if( drugInfoId != null ){
            try{
                Optional<DrugInfo> optional = medicineService.readDrugInfo(drugInfoId);
                return ( optional.isPresent() ) ?
                        ResponseEntityManager.OK.getResponseEntity() :
                        ResponseEntityManager.NOT_FOUND.getResponseEntity();

            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }

        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateDrugInfo")
    public ResponseEntity<?> updateDrugInfo(@RequestBody DrugInfo drugInfo){

        if( drugInfo != null && drugInfo.getId() != null  ){
            try {
                return ResponseEntityManager.OK.getResponseEntity(medicineService.updateDrugInfo(drugInfo));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }



    @PostMapping("/deleteDrugInfo")
    public ResponseEntity<?> deleteDrugInfo(@RequestBody Long drugInfoId){

        if( drugInfoId != null ){
            try{
                medicineService.deleteDrugInfo(drugInfoId);
                return ResponseEntityManager.OK.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteAllDrugInfo")
    public ResponseEntity<?> deleteAllDrugInfo(@RequestBody Login login){

        if( login != null  && login.getId() != null ){
            try{
                medicineService.deleteAllDrugInfo(login);
                return ResponseEntityManager.OK.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/addMedicineInfo")
    public ResponseEntity<?> addMedicineInfo(@RequestBody MedicineInfo medicineInfo){

        if( medicineInfo != null ){
            try{
                return ResponseEntityManager.CREATED.getResponseEntity(medicineService.addMedicineInfo(medicineInfo));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readAllMedicineInfo")
    public ResponseEntity<?> readAllMedicineInfo(){

        try{
            return ResponseEntityManager.OK.getResponseEntity(medicineService.readAllMedicineInfo());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
        }

    }


    @PostMapping("/readMedicineInfo")
    public ResponseEntity<?> readMedicineInfo(@RequestBody Long medicineInfoId){

        if( medicineInfoId != null ){
            try{
                Optional<MedicineInfo> optional = medicineService.readMedicineInfo(medicineInfoId);
                return ( optional.isPresent() )?
                        ResponseEntityManager.OK.getResponseEntity(optional.get()) :
                        ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateMedicineInfo")
    public ResponseEntity<?> updateMedicineInfo(@RequestBody MedicineInfo medicineInfo){

        if( medicineInfo != null && medicineInfo.getId() != null ){
            try{
                return ResponseEntityManager.OK.getResponseEntity(medicineService.updateMedicineInfo(medicineInfo));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteMedicineInfo")
    public ResponseEntity<?> deleteMedicineInfo(@RequestBody MedicineInfo medicineInfo){

        if( medicineInfo != null && medicineInfo.getId() != null ){

            try{
                medicineService.deleteMedicineInfo(medicineInfo);
                return ResponseEntityManager.OK.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }



}
