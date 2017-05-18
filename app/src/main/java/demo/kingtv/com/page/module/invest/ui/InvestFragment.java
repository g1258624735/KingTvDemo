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

package demo.kingtv.com.page.module.invest.ui;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.ArrayList;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.base.MvpFragment;
import demo.kingtv.com.page.base.iml.MvpPresenter;
import demo.kingtv.com.page.base.iml.MvpView;
import demo.kingtv.com.page.module.MainActivity;
import demo.kingtv.com.page.module.invest.adapter.InvestAdapter;
import demo.kingtv.com.page.module.invest.bean.LiveListResult;
import demo.kingtv.com.page.module.invest.iml.IInvestView;
import demo.kingtv.com.page.module.invest.presenter.InvestPrestener;
import demo.kingtv.com.page.module.main.adapter.LiveAdapter;
import demo.kingtv.com.page.module.main.bean.LiveInfo;
import demo.kingtv.com.page.utils.DensityUtil;

/**
 * @author gxj
 * @date 2017/5/11
 * @since 1.0.0
 * 列表页
 */
public class InvestFragment extends MvpFragment<IInvestView, InvestPrestener> implements IInvestView {
    private EasyRecyclerView easyRecyclerView;
    private ArrayList<LiveInfo> listData;
    private InvestAdapter easyLiveAdapter;

    @Override
    public void createPresenter() {
        InvestPrestener investPrestener = new InvestPrestener(this);
        setPresenter(investPrestener);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_invest_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        easyRecyclerView = (EasyRecyclerView) rootView.findViewById(R.id.recyView);
        SpaceDecoration spaceDecoration = new SpaceDecoration(DensityUtil.dp2px(activity, 6));
        easyRecyclerView.addItemDecoration(spaceDecoration);
        easyRecyclerView.setRefreshingColorResources(R.color.color_blue_light);
        listData = new ArrayList<>();
        easyLiveAdapter = new InvestAdapter(activity, listData);
        easyLiveAdapter.setNotifyOnChange(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 2);
        gridLayoutManager.setSpanSizeLookup(easyLiveAdapter.obtainGridSpanSizeLookUp(2));
        easyRecyclerView.setLayoutManager(gridLayoutManager);
        easyRecyclerView.setAdapter(easyLiveAdapter);
    }

    @Override
    public void initListener() {
        easyRecyclerView.setRefreshListener(() -> {
            easyRecyclerView.setRefreshing(false);
        });
    }

    /**
     * 请求网络数据
     */
    @Override
    public void initData() {
        getPresenter().getAllList();
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
    public void onGetLiveList(LiveListResult list) {
        if (list != null) {
            easyLiveAdapter.addAll(list.getData());
            easyLiveAdapter.notifyDataSetChanged();
        }
    }
}

