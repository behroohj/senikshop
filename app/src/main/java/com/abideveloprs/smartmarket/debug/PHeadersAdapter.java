package com.abideveloprs.smartmarket.debug;
/**
 * Created by imanbahmani on 10/5/16 AD.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.abideveloprs.smartmarket.debug.activity.Details;
import com.abideveloprs.smartmarket.debug.orm.pheaderORM;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class PHeadersAdapter extends RecyclerView.Adapter<PHeadersAdapter.MyViewHolder> {

    private Context mContext;
    private List<pheaderORM> albumList;


    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);

        }
    }


    public PHeadersAdapter(Context mContext, List<pheaderORM> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.headers_card, parent, false);





        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final pheaderORM album = albumList.get(position);
        holder.title.setText(album.getTitle());
        holder.title.setBackgroundColor(Color.parseColor("#cc"+album.getColor().replaceFirst("#", "")));
        //holder.title.setBackgroundColor(Color.parseColor(album.getColor()));

        // loading album cover using Glide library

        GlobalClass.ImageCatch(mContext,holder.thumbnail,GlobalClass.imagesaddress+album.getImage());



        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext, holder.title.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(mContext, holder.title.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}