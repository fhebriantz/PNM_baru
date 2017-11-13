package com.duaruang.pnmportal.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.duaruang.pnmportal.R;
import com.duaruang.pnmportal.config.Config;
import com.duaruang.pnmportal.helper.WrapContentDraweeView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.biubiubiu.justifytext.library.JustifyTextView;

public class NewsGeneralDetailActivity extends BaseActivity {

    @BindView(R.id.news_general_detail_title)
    TextView tvTitle;
    @BindView(R.id.news_general_detail_tanggal)
    TextView tvTanggal;
    @BindView(R.id.news_general_detail_description)
    JustifyTextView tvDescription;
    @BindView(R.id.news_general_detail_image)
    WrapContentDraweeView tvPicture;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_news_general_detail;
    }

//    public static String [] menuList={"Absen","Rundown","Materi","Location"};
//    public static int [] iconId={R.drawable.icon_absen,R.drawable.icon_rundown,R.drawable.icon_materi,R.drawable.icon_location};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        if (ab != null)
            ab.setTitle("News");

        tvTitle.setText(getIntent().getStringExtra("title"));
        tvDescription.setText(getIntent().getStringExtra("description"));

        String dateTime[]=getIntent().getStringExtra("created_date").split(" ");

        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        String date = null;
        try {
            Date d = inputFormat.parse(dateTime[0]);
            date = outputFormat.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tvTanggal.setText(date);

        Uri uri = Uri.parse(Config.KEY_URL_ASSET_NEWS + getIntent().getStringExtra("picture"));

        tvPicture.setImageURI(uri);

//        gv=(GridView) findViewById(R.id.gridview_parallax_header);
//        gv.setAdapter(new EventDetailAdapter(this, menuList, iconId));
//        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(EventDetailActivity.this, "You Clicked at " +menuList[+ i], Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
