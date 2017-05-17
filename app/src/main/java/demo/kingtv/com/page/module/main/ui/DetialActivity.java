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

package demo.kingtv.com.page.module.main.ui;

import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.ArrayList;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.base.MvpActivity;
import demo.kingtv.com.page.module.invest.bean.LiveListResult;
import demo.kingtv.com.page.module.main.adapter.LiveAdapter;
import demo.kingtv.com.page.module.main.bean.LiveInfo;
import demo.kingtv.com.page.module.main.iml.IDetialView;
import demo.kingtv.com.page.module.main.presenter.DetialPrestener;
import demo.kingtv.com.page.utils.DensityUtil;

/**
 * @author gxj
 * @date 2017/5/11
 * @since 1.0.0
 * 直播列表页
 */
public class DetialActivity extends MvpActivity<IDetialView, DetialPrestener> implements IDetialView {

    private EasyRecyclerView easyRecyclerView;
    private ArrayList<LiveInfo> listData;
    private LiveAdapter easyLiveAdapter;

    @Override
    public void createPresenter() {
        DetialPrestener homePrestener = new DetialPrestener(this);
        setPresenter(homePrestener);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    protected void initView() {
        easyRecyclerView = (EasyRecyclerView) findViewById(R.id.recyView);
        SpaceDecoration spaceDecoration = new SpaceDecoration(DensityUtil.dp2px(this, 6));
        easyRecyclerView.addItemDecoration(spaceDecoration);
        easyRecyclerView.setRefreshingColorResources(R.color.color_blue_light);
        listData = new ArrayList<>();
        easyLiveAdapter = new LiveAdapter(this, listData);
        easyLiveAdapter.setNotifyOnChange(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(easyLiveAdapter.obtainGridSpanSizeLookUp(2));
        easyRecyclerView.setLayoutManager(gridLayoutManager);
        easyRecyclerView.setAdapter(easyLiveAdapter);
    }

    @Override
    protected void initListener() {
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
        showLoadingDialog();
    }

    @Override
    public void onCompleted() {
        dismissDialog();
    }

    @Override
    public void onError(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetLiveList(LiveListResult list) {
        if (list != null) {
            easyLiveAdapter.addAll(list.getData());
            easyLiveAdapter.notifyDataSetChanged();
        }
    }


}

