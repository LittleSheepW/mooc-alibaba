package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.StateMode;

/**
 * 毕业状态
 */
public class GraduateState extends State {

    public GraduateState() {
        nextState = null;
    }

    @Override
    public void doAction() {
        System.out.println(String.format("学生%s毕业了....", context.getStudent().getName()));
    }
}