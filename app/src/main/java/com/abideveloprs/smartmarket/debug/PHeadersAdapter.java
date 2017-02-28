package com.abideveloprs.smartmarket.debug;
/**
 * Created by imanbahmani on 10/5/16 AD.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abideveloprs.smartmarket.debug.activity.ProductsActivity;
import com.abideveloprs.smartmarket.debug.orm.pheaderORM;

import java.util.List;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class PHeadersAdapter extends RecyclerView.Adapter<PHeadersAdapter.MyViewHolder> {

    private Context mContext;
    private List<pheaderORM> pheaderList;
    private int lastPosition = -1;


    public class MyViewHolder extends RecyclerView.ViewHolder  {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.headerthumbnail);

        }
    }


    public PHeadersAdapter(Context mContext, List<pheaderORM> pheaderList) {
        this.mContext = mContext;
        this.pheaderList = pheaderList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.headers_card, parent, false);





        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final pheaderORM phORM = pheaderList.get(position);
        holder.title.setText(phORM.getTitle());
        holder.title.setBackgroundColor(Color.parseColor("#cc"+phORM.getColor().replaceFirst("#", "")));
        //holder.title.setBackgroundColor(Color.parseColor(phORM.getColor()));

        // loading phORM cover using Glide library

        GlobalClass.ImageCatch(mContext,holder.thumbnail,GlobalClass.imagesaddress+phORM.getImage());

        final Intent intent=new Intent(mContext,ProductsActivity.class);
        intent.putExtra("id",phORM.getidapp());
        intent.putExtra("title",phORM.getTitle());
        intent.putExtra("color",phORM.getColor());
        intent.putExtra("image",phORM.getImage());



        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContext.startActivity(intent);

            }
        });

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mContext.startActivity(intent);


            }
        });

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? android.R.anim.slide_in_left
                        : android.R.anim.slide_out_right);
        holder.itemView.startAnimation(animation);
        lastPosition = position;

    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */


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
        return pheaderList.size();
    }


    private void setAnimation(View viewToAnimate, int position)
    {


        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;

        }



    }
}