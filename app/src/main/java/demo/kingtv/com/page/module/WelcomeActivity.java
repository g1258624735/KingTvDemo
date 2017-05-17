package demo.kingtv.com.page.module;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.base.BaseActivity;

/**
 * @author gxj
 * @date 2017/5/15
 */

public class WelcomeActivity extends BaseActivity {

    public Animation.AnimationListener getAnimationListener() {
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        };

    }

    protected Animation getAnimation() {
        return AnimationUtils.loadAnimation(this, R.anim.splash_alpha);
    }

    protected void startAnimation(View rootView) {
        Animation anim = getAnimation();
        anim.setAnimationListener(getAnimationListener());
        rootView.startAnimation(anim);
    }

    @Override
    protected int getRootViewId() {
        return R.layout.activity_welcome;
    }


    @Override
    protected void initView() {
        hideTopView();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        startAnimation(getRootView());
    }
}
