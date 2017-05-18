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

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;

import java.util.ArrayList;
import java.util.List;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.base.MvpFragment;
import demo.kingtv.com.page.module.main.adapter.CategoryAdapter;
import demo.kingtv.com.page.module.main.bean.LiveCategory;
import demo.kingtv.com.page.module.main.iml.IHomeView;
import demo.kingtv.com.page.module.main.presenter.HomePrestener;
import demo.kingtv.com.page.utils.DensityUtil;

/**
 * @author gxj
 * @date 2017/5/11
 * @since 1.0.0
 * 首页
 */
public class HomeFragment extends MvpFragment<IHomeView, HomePrestener> implements IHomeView {

    private EasyRecyclerView easyRecyclerView;
    private ArrayList<LiveCategory> listData;
    private CategoryAdapter easyLiveAdapter;

    @Override
    public void createPresenter() {
        HomePrestener homePrestener = new HomePrestener(this);
        setPresenter(homePrestener);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_home_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        easyRecyclerView = (EasyRecyclerView) rootView.findViewById(R.id.recyView);
        SpaceDecoration spaceDecoration = new SpaceDecoration(DensityUtil.dp2px(activity, 6));
        easyRecyclerView.addItemDecoration(spaceDecoration);
        easyRecyclerView.setRefreshingColorResources(R.color.color_blue_light);
        listData = new ArrayList<>();
        easyLiveAdapter = new CategoryAdapter(activity, listData);
        easyLiveAdapter.setNotifyOnChange(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(activity, 3);
        gridLayoutManager.setSpanSizeLookup(easyLiveAdapter.obtainGridSpanSizeLookUp(3));
        easyRecyclerView.setLayoutManager(gridLayoutManager);
        easyRecyclerView.setAdapter(easyLiveAdapter);

    }

    @Override
    public void initListener() {
        easyLiveAdapter.setOnItemClickListener((int position) -> {
            Intent intent = new Intent(activity, DetialActivity.class);
            startActivity(intent);
        });
        easyRecyclerView.setRefreshListener(() -> {
            easyRecyclerView.setRefreshing(false);
        });
    }

    /**
     * 请求网络数据
     */
    @Override
    public void initData() {
        getPresenter().getAllCategories();
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
    public void onGetLiveCategory(List<LiveCategory> list) {
        if (list != null) {
            easyLiveAdapter.addAll(list);
            easyLiveAdapter.notifyDataSetChanged();
        }
    }

}

