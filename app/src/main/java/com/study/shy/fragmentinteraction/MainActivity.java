package com.study.shy.fragmentinteraction;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.study.shy.fragmentinteraction.base.BaseFragment;
import com.study.shy.fragmentinteraction.fragment.Fragment1;
import com.study.shy.fragmentinteraction.fragment.Fragment2;
import com.study.shy.fragmentinteraction.fragment.Fragment3;
import com.study.shy.fragmentinteraction.struct.FunctionNoParamNoResult;
import com.study.shy.fragmentinteraction.struct.FunctionWithParamAndResult;
import com.study.shy.fragmentinteraction.struct.FunctionWithResultOnly;
import com.study.shy.fragmentinteraction.struct.FunctionsManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.iv_f1)
    ImageView ivF1;
    @BindView(R.id.rl_f1)
    RelativeLayout rlF1;
    @BindView(R.id.iv_f2)
    ImageView ivF2;
    @BindView(R.id.rl_f2)
    RelativeLayout rlF2;
    @BindView(R.id.iv_f3)
    ImageView ivF3;
    @BindView(R.id.rl_f3)
    RelativeLayout rlF3;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    public FragmentManager mFragmentManager;
    public FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //默认第一个首页被选中高亮显示
        rlF1.setSelected(true);
        mFragmentManager=getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fl_content, fragment1=new Fragment1(),"Fragment1");
        mFragmentTransaction.commit();
    }

    //设置所有按钮都是默认都不选中
    private void seleted() {
        rlF1.setSelected(false);
        rlF2.setSelected(false);
        rlF3.setSelected(false);
    }

    //删除所有Fragment
    private void hideAllFragment(FragmentTransaction transaction) {
        if (fragment1 != null) {
            transaction.hide(fragment1);
        }
        if (fragment2 != null) {
            transaction.hide(fragment2);
        }
        if (fragment3 != null) {
            transaction.hide(fragment3);
        }
    }

    @OnClick({R.id.rl_f1, R.id.rl_f2, R.id.rl_f3})
    public void onViewClicked(View view) {
        mFragmentTransaction = mFragmentManager.beginTransaction(); //开启事务
        hideAllFragment(mFragmentTransaction);
        switch (view.getId()) {
            case R.id.rl_f1:
                seleted();
                rlF1.setSelected(true);
                if (fragment1 == null) {
                    fragment1 = new Fragment1();
                    mFragmentTransaction.add(R.id.fl_content,fragment1,"Fragment1");
                }else{
                    mFragmentTransaction.show(fragment1);
                }
                break;
            case R.id.rl_f2:
                seleted();
                rlF2.setSelected(true);
                if (fragment2 == null) {
                    fragment2 = new Fragment2();
                    mFragmentTransaction.add(R.id.fl_content,fragment2,"Fragment2");
                }else{
                    mFragmentTransaction.show(fragment2);
                }
                break;
            case R.id.rl_f3:
                seleted();
                rlF3.setSelected(true);
                if (fragment3 == null) {
                    fragment3 = new Fragment3();
                    mFragmentTransaction.add(R.id.fl_content,fragment3,"Fragment3");
                }else{
                    mFragmentTransaction.show(fragment3);
                }
                break;
        }
        mFragmentTransaction.commit();
    }

    public void setFunctionsForFragment(String tag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        BaseFragment fragment = (BaseFragment) fragmentManager.findFragmentByTag(tag);
        FunctionsManager functionsManager = FunctionsManager.getInstance();
        fragment.setmFunctionsManager(functionsManager
        .addFunction(new FunctionNoParamNoResult(Fragment1.INTERFACE_NO_PARAM_NO_RESULT) {
            @Override
            public void function() {
                Log.e("function","成功调用无参无返回值的接口");
                Toast.makeText(MainActivity.this,"成功调用无参无返回值的接口",Toast.LENGTH_SHORT).show();
            }
        })
        .addFunction(new FunctionWithResultOnly<String>(Fragment2.INTERFACE_WITH_RESULT_ONLY) {
            @Override
            public String function() {
                return "万能的Interface架构实现成功";
            }
        })
        .addFunction(new FunctionWithParamAndResult<String,String>(Fragment3.INTERFACE_WITH_PARAM_AND_RESULT) {
            @Override
            public String function(String s) {
                return "万能的Interface架构实现成功";
            }

        }));
    }
}
