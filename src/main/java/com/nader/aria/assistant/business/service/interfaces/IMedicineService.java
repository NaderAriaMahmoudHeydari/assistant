package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.medicine.DrugInfo;
import com.nader.aria.assistant.entities.medicine.MedicineInfo;
import java.util.List;
import java.util.Optional;

public interface IMedicineService {


    public DrugInfo addDrugInfo(DrugInfo drugInfo) throws Exception;

    public List<DrugInfo> readAllDrugInfo(Login login) throws Exception;

    public Optional<DrugInfo> readDrugInfo(Long drugInfoId) throws Exception;

    public DrugInfo updateDrugInfo(DrugInfo drugInfo) throws Exception;

    public void deleteDrugInfo(Long drugInfoId) throws Exception;

    public void deleteAllDrugInfo(Login login) throws Exception;

    public MedicineInfo addMedicineInfo(MedicineInfo medicineInfo) throws Exception;

    public List<MedicineInfo> readAllMedicineInfo() throws Exception;

    public Optional<MedicineInfo> readMedicineInfo(Long medicineInfoId) throws Exception;

    public MedicineInfo updateMedicineInfo(MedicineInfo medicineInfo) throws Exception;

    public void deleteMedicineInfo(MedicineInfo medicineInfo) throws Exception;

}
