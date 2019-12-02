package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.StateMode;

/**
 * 报名状态
 */
public class EnrollState extends State {

    public EnrollState() {
        super();
        nextState = new StudyState();
    }

    @Override
    public void doAction() {
        System.out.println(String.format("学生%s报名中....", context.getStudent().getName()));
    }
}