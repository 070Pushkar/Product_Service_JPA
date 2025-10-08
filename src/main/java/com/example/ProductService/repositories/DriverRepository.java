package com.example.ProductService.repositories;

import com.example.ProductService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver , Long >{

  Optional < Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

  @Query(nativeQuery = true, value = "SELECT * from Driver  where id = :id AND licenseNumber = :license")// RAW MYSQL Query ,error is thrown at Run time
  Optional<Driver> rawFindByIdAndLicense(Long id, String license);


  @Query("SELECT d from Driver as d where d.id = :id AND d.licenseNumber = :ln") // Hibernate Query ,error is thrown at compile time
  Optional<Driver> hqlFindByIdAndLicense(Long id, String ln);

}
