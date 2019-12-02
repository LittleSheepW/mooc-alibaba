package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.StateMode;

import com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.entity.Student;

public class Context {
    private Student student;
    private State currentState;

    public void doAction() {
        currentState.doAction();
    }
    
    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        this.currentState.setContext(this);
    }

    public State getNextSate() {
        return currentState.nextState;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}