package vidu.demo.information_gun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.List;

import vidu.demo.information_gun.Model.Gun;
import vidu.demo.information_gun.Model.Photos;
import vidu.demo.information_gun.R;

public class AdapterViewPage extends PagerAdapter {
    private Context context;
    private List<Photos> list;

    public AdapterViewPage(Context context, List<Photos> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size ();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from (container.getContext ()).inflate (R.layout.item_view_page_list_photos,container,false);
        ImageView imageView = view.findViewById (R.id.image_anh);

        Photos photo = list.get (position);
        Glide.with (context).load (photo.getAnh ()).into (imageView);

        container.addView (view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ((View) object);

    }
}
