package com.nader.aria.assistant.dao.medicine_repository;

import com.nader.aria.assistant.entities.medicine.DrugInfo;
import com.nader.aria.assistant.entities.medicine.DrugInfoManager;
import com.nader.aria.assistant.entities.medicine.MedicineInfo;
import com.nader.aria.assistant.entities.medicine.TakingMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface IDrugInfoRepository extends JpaRepository<DrugInfo,Long> {

    public List<DrugInfo> findAllByDrugInfoManager(@Param("drugInfoManager") DrugInfoManager drugInfoManager);
    public List<DrugInfo> findAllByMedicineInfo(@Param("medicineInfo") MedicineInfo medicineInfo);
    public List<DrugInfo> findAllByTakingMedication(@Param("takingMedication") TakingMedication takingMedication);
    public List<DrugInfo> findAllByComplications(@Param("complications") String complications);
    public DrugInfo findByTitle(@Param("title") String title);

}
