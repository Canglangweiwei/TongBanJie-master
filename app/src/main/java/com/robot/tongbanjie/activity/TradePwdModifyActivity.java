package com.robot.tongbanjie.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.robot.tongbanjie.R;
import com.robot.tongbanjie.dialog.PwdDialogFragment;
import com.robot.tongbanjie.widget.InputPasswordView;
import com.robot.tongbanjie.widget.TitleBarView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 修改交易密码
 */
@SuppressWarnings("ALL")
public class TradePwdModifyActivity extends BaseActivity {

    @Bind(R.id.titlebar)
    TitleBarView mTitleBar;
    @Bind(R.id.input_pwd_view)
    InputPasswordView inputPasswordView;
    PwdDialogFragment pwdDialogFragment;

    public static void start(Context context) {
        Intent intent = new Intent(context, TradePwdModifyActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_trade_pwd_modify);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void initTitle() {
        mTitleBar.initTitleWithLeftTxtDrawable("修改交易密码", "取消", R.drawable.btn_back_sel, 5);
        mTitleBar.setOnLeftTxtClickListener(new TitleBarView.OnLeftTxtClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {
        inputPasswordView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (pwdDialogFragment == null) {
                    pwdDialogFragment = PwdDialogFragment.newInstance(TradePwdModifyActivity.this, null, 0);
                    pwdDialogFragment.setOnAddListener(inputPasswordView);
                    pwdDialogFragment.setOnConfirmListener(inputPasswordView);
                    pwdDialogFragment.setOnDeleteListener(inputPasswordView);
                }

                if (pwdDialogFragment != null
                        && pwdDialogFragment.getDialog() != null
                        && pwdDialogFragment.getDialog().isShowing()) {
                    pwdDialogFragment.dismiss();
                } else {
                    pwdDialogFragment.show(getSupportFragmentManager(), null);
                }
            }
        });

        inputPasswordView.setOnPasswdCompletedListener(new InputPasswordView.OnPasswdCompletedListener() {

            @Override
            public void onCompleted(View view) {
                if (pwdDialogFragment != null
                        && pwdDialogFragment.getDialog() != null
                        && pwdDialogFragment.getDialog().isShowing()) {
                    pwdDialogFragment.dismiss();
                }
            }
        });

        inputPasswordView.setOnPasswdConfirmListener(new InputPasswordView.OnPasswdConfirmListener() {

            @Override
            public void onConfirm(List<String> pwds) {
                if (pwds == null || pwds.size() == 0) return;
                for (String data : pwds) Log.d("aaaaaaaaaaa", data);
            }
        });
    }
}
