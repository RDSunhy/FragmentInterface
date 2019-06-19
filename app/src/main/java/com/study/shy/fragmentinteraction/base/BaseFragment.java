package com.study.shy.fragmentinteraction.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.study.shy.fragmentinteraction.MainActivity;
import com.study.shy.fragmentinteraction.struct.Function;
import com.study.shy.fragmentinteraction.struct.FunctionsManager;

/**
 * Created by Administrator on 2019/6/19.
 */

public class BaseFragment extends Fragment {

    public FunctionsManager mFunctionsManager;
    private MainActivity mBaseActivity;

    public void setmFunctionsManager(FunctionsManager functionsManager){
        this.mFunctionsManager = functionsManager;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
            mBaseActivity = (MainActivity) context;
            Log.e("getTag结果",getTag());
            mBaseActivity.setFunctionsForFragment(getTag());
        }
    }
}
