package com.nader.aria.assistant.dao.medicine_repository;

import com.nader.aria.assistant.entities.account.Address;
import com.nader.aria.assistant.entities.account.ContactDetail;
import com.nader.aria.assistant.entities.enums.MedicineType;
import com.nader.aria.assistant.entities.medicine.MedicineInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface IMedicineInfoRepository extends JpaRepository<MedicineInfo,Long> {

    public List<MedicineInfo> findAllByAddress(@Param("address") Address address);
    public List<MedicineInfo> findAllByMedicineType(@Param("medicineType") MedicineType medicineType);
    public List<MedicineInfo> findAllByDescription(@Param("description") String description);
    public List<MedicineInfo> findAllByContactDetail(@Param("contactDetail") ContactDetail contactDetail);
    public MedicineInfo findByTitle(@Param("title") String title);

}
