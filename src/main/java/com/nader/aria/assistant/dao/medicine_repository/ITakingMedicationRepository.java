package com.nader.aria.assistant.dao.medicine_repository;

import com.nader.aria.assistant.entities.medicine.TakingMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import java.util.Calendar;
import java.util.List;

public interface ITakingMedicationRepository extends JpaRepository<TakingMedication,Long> {

    public List<TakingMedication> findAllByUseTime(@Param("useTime") Calendar useTime);
    public List<TakingMedication> findAllByConsumed(@Param("consumed") boolean consumed);

}
