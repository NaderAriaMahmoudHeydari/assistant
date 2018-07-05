package com.nader.aria.assistant.dao.financial_repository;

import com.nader.aria.assistant.entities.abstracts.Fund;
import com.nader.aria.assistant.entities.enums.FinanceType;
import com.nader.aria.assistant.entities.enums.PaymentReceiveType;
import com.nader.aria.assistant.entities.financial.Financial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IFinancialRepository extends JpaRepository<Financial,Long> {

    public List<Financial> findAllByFund(@Param("fund") Fund fund);
    public List<Financial> findAllByValue(@Param("value") Long value);
    public List<Financial> findAllByFinanceType(@Param("financeType") FinanceType financeType);
    public List<Financial> findAllByPaymentReceiveType(@Param("paymentReceiveType") PaymentReceiveType paymentReceiveType);
    public Financial findByTitle(@Param("title") String title);

}
