package com.study.shy.fragmentinteraction.struct;

/**
 * Created by Administrator on 2019/6/19.
 */

public abstract class FunctionWithParamAndResult<Param,Result> extends Function {

    public FunctionWithParamAndResult(String name) {
        super(name);
    }

    public abstract Result function(Param param);
}
