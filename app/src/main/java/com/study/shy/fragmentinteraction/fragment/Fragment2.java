package com.study.shy.fragmentinteraction.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.study.shy.fragmentinteraction.R;
import com.study.shy.fragmentinteraction.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/6/19.
 */

public class Fragment2 extends BaseFragment {

    public static final String INTERFACE_WITH_RESULT_ONLY = Fragment2.class.getName() + "WithResultOnly";
    @BindView(R.id.bn_toast)
    Button bnToast;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
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
        String str = mFunctionsManager.invokeFunction(INTERFACE_WITH_RESULT_ONLY,String.class);
        Toast.makeText(getContext(),str,Toast.LENGTH_SHORT).show();
    }
}
