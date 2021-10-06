package org.example.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.annotation.Service;
import org.example.entities.UserEntity;
import org.example.repository.UserRepository;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserEntity getById(Long id) {
        return userRepository.selectById(id);
    }

    @Override
    public List<UserEntity> getByCondition(String search) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotEmpty(search)) {
            queryWrapper.like(UserEntity::getUserName, search);
        }
        queryWrapper.orderByAsc(UserEntity::getId);
        return userRepository.selectList(queryWrapper);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.insert(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
