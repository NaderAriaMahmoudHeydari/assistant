package com.nader.aria.assistant.dao.financial_repository;

import com.nader.aria.assistant.entities.abstracts.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IFundRepository<F extends Fund> extends JpaRepository<F,Long> {

    public F findAllByMinStock(@Param(value = "minStock") Long minStock);
    public F findAllByMaxStock(@Param(value = "maxStock") Long maxStock);
    public F findAllByCurrentStock(@Param(value = "currentStock") Long currentStock);

}
