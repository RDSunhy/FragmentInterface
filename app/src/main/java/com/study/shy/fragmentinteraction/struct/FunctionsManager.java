package com.study.shy.fragmentinteraction.struct;

import android.text.TextUtils;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Administrator on 2019/6/19.
 */

public class FunctionsManager {

    public static FunctionsManager instance;

    public FunctionsManager(){
        mFunctionNoParamNoResult = new HashMap<>();
        mFunctionWithParamOnly = new HashMap<>();
        mFunctionWithResultOnly = new HashMap<>();
        mFunctionWithParamAndResult = new HashMap<>();
    }

    public static FunctionsManager getInstance(){
        if(instance == null){
            instance = new FunctionsManager();
        }
        return instance;
    }

    public HashMap<String,FunctionNoParamNoResult> mFunctionNoParamNoResult;
    public HashMap<String,FunctionWithParamOnly> mFunctionWithParamOnly;
    public HashMap<String,FunctionWithResultOnly> mFunctionWithResultOnly;
    public HashMap<String,FunctionWithParamAndResult> mFunctionWithParamAndResult;

    /**
     * 无参数无返回值
     * 添加接口 - <接口名,接口>
     * @param function
     * @return
     */
    public FunctionsManager addFunction(FunctionNoParamNoResult function){
        Log.e("addFunction",function.getClass().getName());
        mFunctionNoParamNoResult.put(function.mFunctionName,function);
        return this;
    }

    /**
     * 无参数无返回值
     * 调用接口 - 通过接口名调用
     * @param functionName
     */
    public void invokeFunction(String functionName){
        if (TextUtils.isEmpty(functionName)){
            return;
        }
        if (mFunctionNoParamNoResult != null){
            FunctionNoParamNoResult f = mFunctionNoParamNoResult.get(functionName);
            if(f != null){
                f.function();
            }else {
                try {
                    throw new FunctionException("Function is Null : " + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 无参数有返回值
     * 添加接口 - <接口名,接口>
     * @param function
     * @return
     */
    public FunctionsManager addFunction(FunctionWithResultOnly function){
        Log.e("addFunction",function.getClass().getName());
        mFunctionWithResultOnly.put(function.mFunctionName,function);
        return this;
    }

    /**
     * 无参数有返回值
     * 调用接口 - 通过接口名调用
     * @param functionName
     * @param c
     * @param <Result>
     * @return
     */
    public <Result> Result invokeFunction(String functionName,Class<Result> c){
        if (TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionWithResultOnly != null){
            FunctionWithResultOnly f = mFunctionWithResultOnly.get(functionName);
            if(f != null){
                if(c != null){
                    return c.cast(f.function());
                }else {
                    return (Result) f.function();
                }
            }else {
                try {
                    throw new FunctionException("Function is Null : " + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 有参数无返回值
     * 添加接口 - <接口名,接口>
     * @param function
     * @return
     */
    public FunctionsManager addFunction(FunctionWithParamOnly function){
        Log.e("addFunction",function.getClass().getName());
        mFunctionWithParamOnly.put(function.mFunctionName,function);
        return this;
    }

    /**
     * 有参数无返回值
     * 调用接口 - 通过接口名调用
     * @param functionName
     * @param params
     * @param <Params>
     */
    public <Params> void invokeFunction(String functionName,Params params){
        if (TextUtils.isEmpty(functionName)){
            return;
        }
        if (mFunctionWithParamOnly != null){
            FunctionWithParamOnly f = mFunctionWithParamOnly.get(functionName);
            if(f != null){
                f.function(params);
            }else {
                try {
                    throw new FunctionException("Function is Null : " + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 有参数有返回值
     * 添加接口 - <接口名,接口>
     * @param function
     * @return
     */
    public FunctionsManager addFunction(FunctionWithParamAndResult function){
        Log.e("addFunction",function.getClass().getName());
        mFunctionWithParamAndResult.put(function.mFunctionName,function);
        return this;
    }

    /**
     * 有参数有返回值
     * 调用接口 - 通过接口名调用
     * @param functionName
     * @param params
     * @param <Params>
     */
    public <Result,Params> Result invokeFunction(String functionName,Params params,Class<Result> c){
        if (TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionWithParamAndResult != null){
            FunctionWithParamAndResult f = mFunctionWithParamAndResult.get(functionName);
            if(f != null){
                if(c != null){
                    return c.cast(f.function(params));
                }else {
                    return (Result) f.function(params);
                }
            }else {
                try {
                    throw new FunctionException("Function is Null : " + functionName);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
