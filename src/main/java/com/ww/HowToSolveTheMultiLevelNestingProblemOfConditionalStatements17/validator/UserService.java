package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.validator;


/**
 * @author: Sun
 * @create: 2019-12-02 18:41
 * @version: v1.0
 */
public interface UserService {

    public UserDTO checkUser(UserParam userParam);

    public UserDTO checkUserSome(UserParam userParam);
}
