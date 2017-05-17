package demo.kingtv.com.page.module.main.adapter;

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
import demo.kingtv.com.page.module.main.bean.LiveCategory;

/**
 * @author gxj
 * @date 2017/3/3
 */

public class CategoryAdapter extends RecyclerArrayAdapter<LiveCategory> {
    public CategoryAdapter(Context context, List<LiveCategory> objects) {
        super(context, objects);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LiveViewHolder(parent);
    }

    public class LiveViewHolder extends BaseViewHolder<LiveCategory> {
        ImageView iv;
        TextView tvTitle;

        public LiveViewHolder(ViewGroup parent) {
            super(parent, R.layout.fragment_categorylist_item_main);
            iv = $(R.id.img);
            tvTitle = $(R.id.title);
        }

        @Override
        public void setData(LiveCategory data) {
            super.setData(data);
            Glide.with(getContext()).load(data.getIcon_image()).placeholder(R.mipmap.default_recommend_icon).error(R.mipmap.default_recommend_icon).crossFade().centerCrop().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);
            tvTitle.setText(data.getName());
        }
    }
}
