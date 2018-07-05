package com.nader.aria.assistant.dao.account_repository;

import com.nader.aria.assistant.entities.account.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IAddressRepository extends JpaRepository<Address,Long> {

    public List<Address> findAllByCountry(@Param("country") String country);

    public List<Address> findAllByCountry(@Param("country") String country, Pageable pageable);

    public List<Address> findAllByCountry(@Param("country") String country, Sort sort);

    public List<Address> findAllByCity(@Param("city") String city);

    public List<Address> findAllByCity(@Param("city") String city, Pageable pageable);

    public List<Address> findAllByCity(@Param("city") String city, Sort sort);

    public Address findByFullAddress(@Param("fullAddress") String fullAddress);

    
    
}
