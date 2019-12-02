package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.StateMode;

import com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.entity.Student;

/**
 * 使用状态模式根据状态执行不同的处理函数
 */
public class StateClinet {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("tomcat");

        Context context = new Context();
        context.setStudent(student);

        // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ //
        // 报名状态
        context.setCurrentState(new EnrollState());
        context.doAction();

        // 学习状态
        State nextSate = context.getNextSate();
        while (nextSate != null) {
            context.setCurrentState(nextSate);
            nextSate.doAction();
            nextSate = nextSate.nextState;
        }
    }
}