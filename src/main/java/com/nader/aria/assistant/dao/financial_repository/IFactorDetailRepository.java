package com.nader.aria.assistant.dao.financial_repository;

import com.nader.aria.assistant.entities.financial.Factor;
import com.nader.aria.assistant.entities.financial.FactorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IFactorDetailRepository extends JpaRepository<FactorDetail,Long> {


    public List<FactorDetail> findAllByAmountOf(@Param("amountOf") Long amountOf);
    public List<FactorDetail> findAllByPricePerUnit(@Param("pricePerUnit") Long pricePerUnit);
    public List<FactorDetail> findAllBySum(@Param("sum") Long sum);
    public List<FactorDetail> findAllByFactor(@Param("factor") Factor factor);
    public FactorDetail findByTitle(@Param("title") String title);
    public void deleteAllByFactor(@Param("factor") Factor factor);

}
