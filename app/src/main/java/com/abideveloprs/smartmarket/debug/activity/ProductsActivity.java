package com.abideveloprs.smartmarket.debug.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abideveloprs.smartmarket.debug.ProductsAdapter;
import com.abideveloprs.smartmarket.debug.GlobalClass;
import com.abideveloprs.smartmarket.debug.R;
import com.abideveloprs.smartmarket.debug.orm.productORM;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductsAdapter adapter;
    private List<productORM> albumList;
    private String headerTitle,headerColor,headerImage;
    private int headerId;
    TextView header_title;
    RelativeLayout toolbarrelativeview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GlobalClass.overrideFont(getApplicationContext(), "SERIF", "Yekan.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initCollapsingToolbar();

        GlobalClass.context=this;
        ViewGroup group = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        GlobalClass.setAllTextView(group);

        Intent intent=getIntent();
        headerId=     intent.getIntExtra("id",0);
        headerTitle=  intent.getStringExtra("title");
        headerColor=  intent.getStringExtra("color");
        headerImage=  intent.getStringExtra("image");

        recyclerView        = (RecyclerView)   findViewById(R.id.recycler_view);
        header_title        = (TextView)       findViewById(R.id.header_title);
        toolbarrelativeview = (RelativeLayout) findViewById(R.id.toolbarrelativeview);

        header_title.setText(headerTitle);
        toolbarrelativeview.setBackgroundColor(Color.parseColor("#"+headerColor));


        albumList= Select.from(productORM.class)
                .where(Condition.prop("phead").eq(headerId))
                .list();

        adapter = new ProductsAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareAlbums();

        try {
            //Glide.with(this).load(R.drawable.slideriii).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");

        //collapsingToolbar.setBackgroundColor(Color.parseColor("#"+headerColor));

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
//        int[] covers = new int[]{
//                R.drawable.p,
//                R.drawable.pi,
//                R.drawable.piii,
//                R.drawable.piiii
//        };

//        pheaderORM a = new pheaderORM("چای سبز", 13, R.drawable.p);
//        albumList.add(a);
//
//        a = new pheaderORM("موبایل نوکیا", 8, R.drawable.pi);
//        albumList.add(a);
//
//        a = new pheaderORM("سامسونگ", 11, R.drawable.piii);
//        albumList.add(a);
//
//        a = new pheaderORM("لپ تاپ", 12, R.drawable.piiii);
//        albumList.add(a);


        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
