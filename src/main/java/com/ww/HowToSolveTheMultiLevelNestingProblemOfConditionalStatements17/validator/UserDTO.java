package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private Integer age;
    private String nickName;
    private Date birthDay;
}