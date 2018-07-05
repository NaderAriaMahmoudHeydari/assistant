package com.nader.aria.assistant.dao.financial_repository;

import com.nader.aria.assistant.entities.enums.PayType;
import com.nader.aria.assistant.entities.financial.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IPaymentRepository extends JpaRepository<Payment,Long> {

    public List<Payment> findAllByPayed(@Param("payed") boolean payed);
    public List<Payment> findAllByPayType(@Param("payType") PayType payType);
    public List<Payment> findAllBySeller(@Param("seller") String seller);

}
