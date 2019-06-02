package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Page<User> findAll(Pageable pageable);

    //search by name
    List<User> findAllByNameFirstNameIgnoreCaseOrNameMiddleNameIgnoreCaseOrNameLastNameIgnoreCaseOrNameSuffixIgnoreCase(
            String firstName,
            String middleName,
            String lastName,
            String suffix);

    //search by contact info
    List<User> findAllByContactInfoEmailIgnoreCaseOrContactInfoMobileOrContactInfoTelephone(
            String email,
            String mobile,
            String telephone);

    //search by address
    List<User> findAllByAddressStreetIgnoreCaseOrAddressCityIgnoreCaseOrAddressStateIgnoreCaseOrAddressZipCode(
            String street,
            String city,
            String state,
            Integer zipCode);
}
