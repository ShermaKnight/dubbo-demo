package org.example.service;

import org.example.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity getById(Long id);

    List<UserEntity> getByCondition(String search);

    void save(UserEntity userEntity);

    void deleteById(Long id);
}
