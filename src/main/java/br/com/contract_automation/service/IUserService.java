package br.com.contract_automation.service;

import br.com.contract_automation.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

public interface IUserService {

    @Transactional
    UserEntity create(UserEntity user);
}
