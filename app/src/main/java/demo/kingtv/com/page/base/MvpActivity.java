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

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import demo.kingtv.com.page.base.iml.BaseMvpDelegateCallback;
import demo.kingtv.com.page.base.iml.MvpPresenter;
import demo.kingtv.com.page.base.iml.MvpView;

/**
 * @author gxj
 *         date 2017/5/11
 * @since 1.0.0
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends BaseActivity implements BaseMvpDelegateCallback {
    protected P presenter;

    public abstract void createPresenter();


    @NonNull
    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(MvpPresenter presenter) {
        this.presenter = (P) presenter;
    }


    @NonNull
    @Override
    public V getMvpView() {
        return (V) this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter!=null){
            presenter.detachView(true);
            presenter=null;
        }
    }
}

