/*
 * Copyright 2015 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo.kingtv.com.page.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.module.MainActivity;

/**
 * @author gxj
 *         date 2017/5/11
 * @since 1.0.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ImageView imgLeft;
    private TextView tvTitle;
    private ImageView imgRight;
    private LinearLayout layoutTop;
    private FrameLayout rootContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    private void initView() {
        imgLeft = (ImageView) findViewById(R.id.ivLeft);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        imgRight = (ImageView) findViewById(R.id.ivRight);
        layoutTop = (LinearLayout) findViewById(R.id.layout_top_root);
        rootContent = (FrameLayout) findViewById(R.id.main_root_content);
        View view = getLayoutInflater().inflate(getRootViewId(), null);
        rootContent.addView(view, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
        if ((this instanceof MainActivity)) {
            hideLeftView();
        }
    }


    protected abstract int getRootViewId();

    protected View getRootView() {
        return rootContent;
    }

    protected void hideTopView() {
        layoutTop.setVisibility(View.GONE);
    }

    protected void showTopView() {
        layoutTop.setVisibility(View.VISIBLE);
    }

    protected void showRightView() {
        imgRight.setVisibility(View.VISIBLE);
    }

    protected void showLeftView() {
        imgLeft.setVisibility(View.VISIBLE);
    }

    protected void hideLeftView() {
        imgLeft.setVisibility(View.INVISIBLE);
    }

    /**
     * 设置头部文案
     */
    public void setTopTitle(String title) {
        tvTitle.setText(title);
    }


}

