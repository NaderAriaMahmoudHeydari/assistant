package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.IMedicineService;
import com.nader.aria.assistant.dao.medicine_repository.IDrugInfoManagerRepository;
import com.nader.aria.assistant.dao.medicine_repository.IDrugInfoRepository;
import com.nader.aria.assistant.dao.medicine_repository.IMedicineInfoRepository;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.enums.MedicineTestType;
import com.nader.aria.assistant.entities.enums.MedicineType;
import com.nader.aria.assistant.entities.medicine.DrugInfo;
import com.nader.aria.assistant.entities.medicine.DrugInfoManager;
import com.nader.aria.assistant.entities.medicine.MedicineInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements IMedicineService {

    private IDrugInfoManagerRepository drugInfoManagerRepository;
    private IDrugInfoRepository drugInfoRepository;
    private IMedicineInfoRepository medicineInfoRepository;

    @Autowired
    public MedicineServiceImpl(IDrugInfoManagerRepository drugInfoManagerRepository,
                               IDrugInfoRepository drugInfoRepository,
                               IMedicineInfoRepository medicineInfoRepository){

        this.drugInfoManagerRepository = drugInfoManagerRepository;
        this.drugInfoRepository = drugInfoRepository;
        this.medicineInfoRepository = medicineInfoRepository;
    }

    @Override
    @Transactional
    public DrugInfo addDrugInfo(DrugInfo drugInfo) throws Exception{
        return drugInfoRepository.save(drugInfo);
    }

    @Override
    @Transactional
    public List<DrugInfo> readAllDrugInfo(Login login) throws Exception{
        DrugInfoManager drugInfoManager = drugInfoManagerRepository.findByLogin(login);
        return drugInfoRepository.findAllByDrugInfoManager(drugInfoManager);
    }

    @Override
    @Transactional
    public Optional<DrugInfo> readDrugInfo(Long drugInfoId) throws Exception{
        return drugInfoRepository.findById(drugInfoId);
    }

    @Override
    @Transactional
    public DrugInfo updateDrugInfo(DrugInfo drugInfo) throws Exception{
        return drugInfoRepository.save(drugInfo);
    }

    @Override
    @Transactional
    public void deleteDrugInfo(Long drugInfoId) throws Exception{
        drugInfoRepository.deleteById(drugInfoId);
    }

    @Override
    @Transactional
    public void deleteAllDrugInfo(Login login) throws Exception{
        DrugInfoManager drugInfoManager = drugInfoManagerRepository.findByLogin(login);
        drugInfoRepository.deleteAllByDrugInfoManager(drugInfoManager);
    }

    @Override
    @Transactional
    public MedicineInfo addMedicineInfo(MedicineInfo medicineInfo) throws Exception{
        return medicineInfoRepository.save(medicineInfo);
    }

    @Override
    @Transactional
    public List<MedicineInfo> readAllMedicineInfo() throws Exception{
        return medicineInfoRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<MedicineInfo> readMedicineInfo(Long medicineInfoId) throws Exception{
        return medicineInfoRepository.findById(medicineInfoId);
    }

    @Override
    @Transactional
    public MedicineInfo updateMedicineInfo(MedicineInfo medicineInfo) throws Exception{
        return medicineInfoRepository.save(medicineInfo);
    }

    @Override
    @Transactional
    public void deleteMedicineInfo(MedicineInfo medicineInfo) throws Exception{
        medicineInfoRepository.delete(medicineInfo);
    }


}
