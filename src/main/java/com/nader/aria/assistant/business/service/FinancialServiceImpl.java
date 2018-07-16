package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.IFinancialService;
import com.nader.aria.assistant.dao.financial_repository.IFactorDetailRepository;
import com.nader.aria.assistant.dao.financial_repository.IFinancialRepository;
import com.nader.aria.assistant.dao.financial_repository.IFundManagerRepository;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.enums.FinanceType;
import com.nader.aria.assistant.entities.financial.Factor;
import com.nader.aria.assistant.entities.financial.FactorDetail;
import com.nader.aria.assistant.entities.financial.Financial;
import com.nader.aria.assistant.entities.financial.FundManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialServiceImpl implements IFinancialService {

    private IFinancialRepository financialRepository;
    private IFactorDetailRepository factorDetailRepository;
    private IFundManagerRepository fundManagerRepository;

    @Autowired
    public FinancialServiceImpl(IFinancialRepository financialRepository,
                                IFactorDetailRepository factorDetailRepository,
                                IFundManagerRepository fundManagerRepository ){
        this.financialRepository = financialRepository;
        this.factorDetailRepository = factorDetailRepository;
        this.fundManagerRepository = fundManagerRepository;
    }
    @Override
    @Transactional
    public Financial save(Financial financial) throws Exception{
        return financialRepository.save(financial);
    }

    @Override
    @Transactional
    public Optional<Financial> readFinancial(Long financialId) throws Exception{
       return financialRepository.findById(financialId);
    }

    @Override
    @Transactional
    public List<Financial> readAllFinancial() throws Exception{
        return financialRepository.findAll();
    }

    @Override
    @Transactional
    public List<Financial> readAllFinancialByType(FinanceType financeType) throws Exception{
        return financialRepository.findAllByFinanceType(financeType);
    }

    @Override
    @Transactional
    public Financial updateFinancial(Financial financial) throws Exception{
        return financialRepository.save(financial);
    }

    @Override
    @Transactional
    public void deleteFinancial(Financial financial) throws Exception{
        financialRepository.delete(financial);
    }

    @Override
    @Transactional
    public List<FactorDetail> readFactorDetails(Factor factor) throws Exception{
        return factorDetailRepository.findAllByFactor(factor);
    }

    @Override
    @Transactional
    public Optional<FactorDetail> readFactorDetail(Long factorDetailId) throws Exception{
        return factorDetailRepository.findById(factorDetailId);
    }

    @Override
    @Transactional
    public FactorDetail updateFactorDetail(FactorDetail factorDetail) throws Exception{
        return factorDetailRepository.save(factorDetail);
    }

    @Override
    @Transactional
    public void deleteFactorDetail(FactorDetail factorDetail) throws Exception{
        factorDetailRepository.delete(factorDetail);
    }

    @Override
    @Transactional
    public void deleteFactorDetail(Long factorDetailId) throws Exception{
        factorDetailRepository.deleteById(factorDetailId);
    }

    @Override
    @Transactional
    public void deleteFactorDetails(Factor factor) throws Exception{
        factorDetailRepository.deleteAllByFactor(factor);
    }

    @Override
    @Transactional
    public void deleteFactorDetails(List<FactorDetail> factorDetails) throws Exception{
        factorDetailRepository.deleteAll(factorDetails);
    }

    @Override
    @Transactional
    public FundManager readFundManager(Login login) throws Exception{
        return fundManagerRepository.findByLogin(login);
    }

    @Override
    @Transactional
    public FundManager updateFundManager(FundManager fundManager) throws Exception{
        return fundManagerRepository.save(fundManager);
    }

}
