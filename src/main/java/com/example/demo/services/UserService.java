package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User findUser(Long id){
        if(userRepository.existsById(id)){
            return userRepository.getOne(id);
        }

        throw new NullPointerException("no data found at id " + id);
    }

    public User updateUser(Long id, User user){
        if(userRepository.existsById(id)){
            user.setId(id);
            return userRepository.save(user);
        }

        throw new NullPointerException("Trying to update non-existing data at id " + id);
    }

    public Boolean deleteUser(Long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }

        throw new NullPointerException("trying to delete a non-existing data at id " + id);
    }

    public List<User> findNameByQuery(String firstName, String middleName, String lastName, String suffix ){
        return userRepository.findAllByNameFirstNameIgnoreCaseOrNameMiddleNameIgnoreCaseOrNameLastNameIgnoreCaseOrNameSuffixIgnoreCase(firstName, middleName, lastName, suffix);
    }

    public List<User> findContactInfoByQuery(String email, String mobile, String telephone){
        return userRepository.findAllByContactInfoEmailIgnoreCaseOrContactInfoMobileOrContactInfoTelephone(email, mobile, telephone);
    }

    public List<User> findAddressByQuery(String street, String city, String state, Integer zipCode){
        return userRepository.findAllByAddressStreetIgnoreCaseOrAddressCityIgnoreCaseOrAddressStateIgnoreCaseOrAddressZipCode(street, city, state, zipCode);
    }

    public Page<User> findAllPageable(Pageable pageable){
        return userRepository.findAll(pageable);
    }
}
