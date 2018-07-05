package com.nader.aria.assistant.dao.medicine_repository;

import com.nader.aria.assistant.entities.medicine.MedicineInfo;
import com.nader.aria.assistant.entities.medicine.MedicineVisit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IMedicineVisitRepository extends JpaRepository<MedicineVisit,Long> {

    public MedicineVisit findByMedicineInfo(@Param("medicineInfo") MedicineInfo medicineInfo);

}
