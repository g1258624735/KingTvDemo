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

package demo.kingtv.com.page.module.mine.ui;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.base.MvpFragment;
import demo.kingtv.com.page.base.iml.MvpPresenter;
import demo.kingtv.com.page.base.iml.MvpView;
import demo.kingtv.com.page.module.MainActivity;
import demo.kingtv.com.page.module.main.bean.LiveCategory;
import demo.kingtv.com.page.module.mine.iml.IMineView;
import demo.kingtv.com.page.module.mine.presenter.MinePrestener;

/**
 * @author gxj
 *         date 2017/5/11
 * @since 1.0.0
 * 列表页
 */
public class MineFragment extends MvpFragment<IMineView, MinePrestener> implements IMineView {

    private LinearLayout linear_tel;

    @Override
    public void createPresenter() {
        MinePrestener prestener = new MinePrestener(this);
        setPresenter(prestener);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_mine_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        linear_tel = (LinearLayout) rootView.findViewById(R.id.linear_tel);
    }

    @Override
    public void initListener() {
        linear_tel.setOnClickListener((v) -> {
            activity.showOneDialog("您即将拨打电话 110");
        });
    }

    @Override
    public void initData() {
        getPresenter().getMineInfo();
    }

    @Override
    public void showProgress() {
        activity.showLoadingDialog();
    }

    @Override
    public void onCompleted() {
        activity.dismissDialog();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetMine(List<LiveCategory> list) {

    }
}

