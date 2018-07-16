package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.enums.FinanceType;
import com.nader.aria.assistant.entities.financial.Factor;
import com.nader.aria.assistant.entities.financial.FactorDetail;
import com.nader.aria.assistant.entities.financial.Financial;
import com.nader.aria.assistant.entities.financial.FundManager;
import java.util.List;
import java.util.Optional;

public interface IFinancialService {

    public Financial save(Financial financial) throws Exception;

    public Optional<Financial> readFinancial(Long financialId) throws Exception;

    public List<Financial> readAllFinancial() throws Exception;

    public List<Financial> readAllFinancialByType(FinanceType financeType) throws Exception;

    public Financial updateFinancial(Financial financial) throws Exception;

    public void deleteFinancial(Financial financial) throws Exception;

    public List<FactorDetail> readFactorDetails(Factor factor) throws Exception;

    public Optional<FactorDetail> readFactorDetail(Long factorDetailId) throws Exception;

    public FactorDetail updateFactorDetail(FactorDetail factorDetail) throws Exception;

    public void deleteFactorDetail(FactorDetail factorDetail) throws Exception;

    public void deleteFactorDetail(Long factorDetailId) throws Exception;

    public void deleteFactorDetails(Factor factor) throws Exception;

    public void deleteFactorDetails(List<FactorDetail> factorDetails) throws Exception;

    public FundManager readFundManager(Login login) throws Exception;

    public FundManager updateFundManager(FundManager fundManager) throws Exception;

}
