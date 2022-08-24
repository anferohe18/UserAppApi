package com.applaudo.andres.userManagementApp.repository;

import com.applaudo.andres.userManagementApp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {

}
