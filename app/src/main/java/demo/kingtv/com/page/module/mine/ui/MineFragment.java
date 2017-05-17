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

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.base.MvpFragment;
import demo.kingtv.com.page.base.iml.MvpPresenter;
import demo.kingtv.com.page.base.iml.MvpView;
import demo.kingtv.com.page.module.MainActivity;

/**
 * @author gxj
 *         date 2017/5/11
 * @since 1.0.0
 * 列表页
 */
public class MineFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment  {

    @Override
    public void createPresenter() {

    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_mine_layout;
    }

    @Override
    public void initUI(View rootView) {

    }

    @Override
    public void initData() {
    }
}

