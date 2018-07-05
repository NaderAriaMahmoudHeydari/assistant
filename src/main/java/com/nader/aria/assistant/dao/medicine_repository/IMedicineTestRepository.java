package com.nader.aria.assistant.dao.medicine_repository;

import com.nader.aria.assistant.entities.enums.MedicineTestType;
import com.nader.aria.assistant.entities.medicine.MedicineTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IMedicineTestRepository extends JpaRepository<MedicineTest,Long> {

    public List<MedicineTest> findAllByValue(@Param("value") String value);
    public List<MedicineTest> findAllByRelatedDiseases(@Param("relatedDiseases") boolean relatedDiseases);
    public List<MedicineTest> findAllByMedicineTestType(@Param("medicineTestType") MedicineTestType medicineTestType);
}
