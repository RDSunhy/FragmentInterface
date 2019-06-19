package com.study.shy.fragmentinteraction.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.study.shy.fragmentinteraction.R;
import com.study.shy.fragmentinteraction.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/6/19.
 */

public class Fragment1 extends BaseFragment {

    public static final String INTERFACE_NO_PARAM_NO_RESULT = Fragment1.class.getName() + "NoParamNoResult";
    @BindView(R.id.bn_toast)
    Button bnToast;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.bn_toast)
    public void onViewClicked() {
        Log.e("接口名",INTERFACE_NO_PARAM_NO_RESULT);
        mFunctionsManager.invokeFunction(INTERFACE_NO_PARAM_NO_RESULT);
    }
}
