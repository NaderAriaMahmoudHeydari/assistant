package com.nader.aria.assistant.dao.financial_repository;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.financial.CurrentFund;
import com.nader.aria.assistant.entities.financial.FundManager;
import com.nader.aria.assistant.entities.financial.SavingsFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IFundManagerRepository extends JpaRepository<FundManager,Long> {

    @Query(value ="select f.currentFund from FundManager as f where f.id =:id ")
    public CurrentFund getCurrentFund(@Param("id") Long id);

    @Query(value ="select f.savingsFund from FundManager as f where f.id =:id ")
    public SavingsFund getSavingsFund(@Param("id") Long id);

    public FundManager findByLogin(@Param("login") Login login);

}
