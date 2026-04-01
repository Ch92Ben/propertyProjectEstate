package com.fdmgroup.RealEstateApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RealEstateApp.model.Property;
import com.fdmgroup.RealEstateApp.model.User;

@Repository
public interface PropertyDao extends JpaRepository<Property, Integer> {

	@Query("SELECT p FROM Property p WHERE seller = :user")
	List<Property> getMyProperties(@Param("user") User user);

	Property findByPropertyId(@Param("propertyId") int propertyId);

	Property findByPropertyAddress(@Param("propertyAddress") String propertyAddress);
}
