package com.applaudo.andres.userManagementApp.service;

import com.applaudo.andres.userManagementApp.entity.UserEntity;
import com.applaudo.andres.userManagementApp.mapper.UserMapper;
import com.applaudo.andres.userManagementApp.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper mapper = Mappers.getMapper(UserMapper.class);

    public UserEntity createUser(UserEntity userEntity){
        if(userRepository.existsById(userEntity.getEmail())){
            throw new DataIntegrityViolationException("The userEntity already exists with the given email account");
        }else{
            return userRepository.save(userEntity);
        }

    }

    public List<UserEntity> createUsers(List<UserEntity> userEntities){
        return userRepository.saveAll(userEntities);
    }

    public UserEntity getUserByEmail(String email) {
        Optional<UserEntity> optionalUser = userRepository.findById(email);
        if(optionalUser.isPresent()){
            UserEntity userEntity = optionalUser.get();
            return userEntity;
        }else{
            throw new EntityNotFoundException();
        }

    }

    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity currentUserEntity = getUserByEmail(userEntity.getEmail());
        currentUserEntity.setFirstName(userEntity.getFirstName());
        currentUserEntity.setLastName(userEntity.getLastName());
        currentUserEntity.setPhone(userEntity.getPhone());
        userRepository.save(currentUserEntity);
        return currentUserEntity;

    }

    public String deleteUserByEmail(String email){
        Optional<UserEntity> optionalUser = userRepository.findById(email);
        if(optionalUser.isPresent()){
            userRepository.deleteById(email);
            return "UserEntity got deleted";
        }else{
            throw new EntityNotFoundException();
        }
    }



}
