package vidu.demo.information_gun.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import vidu.demo.information_gun.Aciton.ItemClick;
import vidu.demo.information_gun.Model.Gun;
import vidu.demo.information_gun.R;

public class AdapterGun extends RecyclerView.Adapter<AdapterGun.ViewHodelGun>{
    private Context context;
    private List<Gun> list;
    ItemClick itemClick;

    public AdapterGun(Context context, List<Gun> list, ItemClick itemClick) {
        this.context = context;
        this.list = list;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ViewHodelGun onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (context).inflate (R.layout.item_recy_view_dach_sach_gun,null);
        return new ViewHodelGun (view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelGun holder, int position) {
        Gun gun = list.get (position);
        Glide.with (context).load (gun.getAnhSung ()).into (holder.image_gun);
        holder.clickItem.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                itemClick.chiTiet (gun);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    class ViewHodelGun extends RecyclerView.ViewHolder{
        ImageView image_gun;
        ConstraintLayout clickItem;
        public ViewHodelGun(@NonNull View itemView) {
            super (itemView);
            image_gun = itemView.findViewById (R.id.image_gun);
            clickItem = itemView.findViewById (R.id._contrain_layout);
        }
    }
}
