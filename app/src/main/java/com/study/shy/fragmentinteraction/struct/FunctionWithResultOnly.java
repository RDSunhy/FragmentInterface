package com.study.shy.fragmentinteraction.struct;

/**
 * Created by Administrator on 2019/6/19.
 */

public abstract class FunctionWithResultOnly<Result> extends Function {

    public FunctionWithResultOnly(String name) {
        super(name);
    }

    public abstract Result function();
}
