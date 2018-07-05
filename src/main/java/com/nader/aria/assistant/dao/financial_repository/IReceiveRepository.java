package com.nader.aria.assistant.dao.financial_repository;

import com.nader.aria.assistant.entities.enums.ReceiveType;
import com.nader.aria.assistant.entities.financial.Receive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IReceiveRepository extends JpaRepository<Receive,Long> {

    public List<Receive> findAllByReceived(@Param("received") boolean received);
    public List<Receive> findAllByReceiveType(@Param("receiveType") ReceiveType receiveType);
    public List<Receive> findAllByPayer(@Param("payer") String payer);

}
