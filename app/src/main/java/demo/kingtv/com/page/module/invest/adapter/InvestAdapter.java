package demo.kingtv.com.page.module.invest.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import demo.kingtv.com.page.R;
import demo.kingtv.com.page.module.main.bean.LiveInfo;

/**
 * @author gxj
 * @date 2017/3/3
 */

public class InvestAdapter extends RecyclerArrayAdapter<LiveInfo> {
    public InvestAdapter(Context context, List<LiveInfo> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LiveViewHolder(parent);
    }

    public class LiveViewHolder extends BaseViewHolder<LiveInfo> {
        ImageView iv;
        TextView tvTitle;

        public LiveViewHolder(ViewGroup parent) {
            super(parent, R.layout.activity_list_item_main);
            iv = $(R.id.img);
            tvTitle = $(R.id.title);
        }

        @Override
        public void setData(LiveInfo data) {
            super.setData(data);
            Glide.with(getContext()).load(data.getRecommend_image()).placeholder(R.mipmap.default_recommend_icon).error(R.mipmap.default_recommend_icon).crossFade().centerCrop().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
            tvTitle.setText(data.getAnnouncement());
        }
    }
}
