package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.interfaces.IFinancialService;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.enums.FinanceType;
import com.nader.aria.assistant.entities.enums.PayType;
import com.nader.aria.assistant.entities.enums.PaymentReceiveType;
import com.nader.aria.assistant.entities.enums.ReceiveType;
import com.nader.aria.assistant.entities.financial.Factor;
import com.nader.aria.assistant.entities.financial.FactorDetail;
import com.nader.aria.assistant.entities.financial.Financial;
import com.nader.aria.assistant.entities.financial.FundManager;
import com.nader.aria.assistant.entities.enums.FinancialType;
import com.nader.aria.assistant.utils.ResponseEntityManager;
import com.sun.org.apache.bcel.internal.generic.FADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/financial")
public class FinancialWebService {

    private IFinancialService financialService;

    @Autowired
    public FinancialWebService(IFinancialService financialService){

        this.financialService = financialService;
    }

    @GetMapping("/getFinancialTypes")
    public ResponseEntity<?> getFinancialTypes(){
        return ResponseEntityManager.OK.getResponseEntity(FinancialType.values());
    }

    @GetMapping("/getFinanceTypes")
    public ResponseEntity<?> getFinanceTypes(){
        return ResponseEntityManager.OK.getResponseEntity(FinanceType.values());
    }

    @GetMapping("/getPaymentReceiveTypes")
    public ResponseEntity<?> getPaymentReceiveTypes(){
        return ResponseEntityManager.OK.getResponseEntity(PaymentReceiveType.values());
    }

    @GetMapping("/getPayTypes")
    public ResponseEntity<?> getPayTypes(){
        return ResponseEntityManager.OK.getResponseEntity(PayType.values());
    }

    @GetMapping("/getReceiveTypes")
    public ResponseEntity<?> getReceiveTypes(){
        return ResponseEntityManager.OK.getResponseEntity(ReceiveType.values());
    }

    @PostMapping("/readFactorDetails")
    public ResponseEntity<?> readFactorDetails(@RequestBody Factor factor){

        if( factor != null && factor.getId() != null ){

            try{
                return ResponseEntityManager.OK.getResponseEntity(financialService.readFactorDetails(factor));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }

        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readFactorDetail")
    public ResponseEntity<?> readFactorDetail(@RequestBody Long factorDetailsId){

        if( factorDetailsId != null ){
            try {
                return ResponseEntityManager.OK.getResponseEntity(financialService.readFactorDetail(factorDetailsId));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateFactorDetail")
    public ResponseEntity<?> updateFactorDetail(@RequestBody FactorDetail factorDetail){

        if( factorDetail != null && factorDetail.getId() != null ){
            try {
                return ResponseEntityManager.OK.getResponseEntity(financialService.updateFactorDetail(factorDetail));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteFactorDetail")
    public ResponseEntity<?> deleteFactorDetail(@RequestBody FactorDetail factorDetail){

        if( factorDetail != null && factorDetail.getId() != null ){
            try{
                financialService.deleteFactorDetail(factorDetail);
                return ResponseEntityManager.OK.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteSelectedFactorDetail")
    public ResponseEntity<?> deleteSelectedFactorDetail(@RequestBody Long factorDetailsId){

        if( factorDetailsId != null ){
            try {
                financialService.deleteFactorDetail(factorDetailsId);
                return ResponseEntityManager.OK.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteFactorDetails")
    public ResponseEntity<?> deleteFactorDetails(@RequestBody Factor factor){

        if( factor != null && factor.getId() != null ){
            try{
                financialService.deleteFactorDetails(factor);
                return ResponseEntityManager.OK.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteSelectedFactorDetails")
    public ResponseEntity<?> deleteSelectedFactorDetails(@RequestBody List<FactorDetail> factorDetails){

        if(factorDetails != null && factorDetails.size() != 0 ){

            try{
                financialService.deleteFactorDetails(factorDetails);
                return ResponseEntityManager.OK.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readFundManager")
    public ResponseEntity<?> readFundManager(@RequestBody Login login){

        if( login != null && login.getId() != null ){
            try{

                return ResponseEntityManager.OK.getResponseEntity(financialService.readFundManager(login));

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateFundManager")
    public ResponseEntity<?> updateFundManager(@RequestBody FundManager fundManager){

        if( fundManager != null && fundManager.getId() != null ){

            try {
               return ResponseEntityManager.OK.getResponseEntity( financialService.updateFundManager(fundManager) );
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

    }


}
