package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.StateMode;

/**
 * 学习状态
 */
public class StudyState extends State {

    public StudyState() {
        nextState = new GraduateState();
    }

    @Override
    public void doAction() {
        System.out.println(String.format("学生%s正在学习....", context.getStudent().getName()));
    }
}