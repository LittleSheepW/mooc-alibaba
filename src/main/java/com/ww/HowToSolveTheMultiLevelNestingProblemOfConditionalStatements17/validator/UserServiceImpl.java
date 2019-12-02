package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.validator;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * TODO: 2019-12-02 现阶段无法理解此种模式
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private ValidatorChain validatorChain;

    @Override
    public UserDTO checkUser(UserParam userParam) {

        // 参数校验
        validatorChain.checkParam(userParam);
        // 业务逻辑
        return new UserDTO("测试", 18, "sun", new Date());
    }

    @Override
    public UserDTO checkUserSome(UserParam userParam) {
        // 参数校验(只校验类型为Some的)
        validatorChain.checkParam(userParam, param -> param.getGroups().contains(UserValidateGroupEnum.SOME));

        // 业务逻辑
        return new UserDTO("测试", 18, "sun", new Date());
    }
}