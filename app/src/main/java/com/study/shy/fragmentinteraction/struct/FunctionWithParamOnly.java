package com.study.shy.fragmentinteraction.struct;

/**
 * Created by Administrator on 2019/6/19.
 */

public abstract class FunctionWithParamOnly<Param> extends Function {

    public FunctionWithParamOnly(String name) {
        super(name);
    }

    public abstract void function(Param param);
}
