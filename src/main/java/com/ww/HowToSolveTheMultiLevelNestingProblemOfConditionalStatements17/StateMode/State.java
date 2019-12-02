package com.ww.HowToSolveTheMultiLevelNestingProblemOfConditionalStatements17.StateMode;

import lombok.Data;

@Data
public abstract class State {
    protected Context context;

    protected State nextState;

    public void setContext(Context context) {
        this.context = context;
    }

    abstract void doAction();
}