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

public class EventGeneralDetailActivity extends BaseActivity {

    @BindView(R.id.event_general_detail_title)
    TextView tvTitle;
    @BindView(R.id.event_general_detail_tanggal)
    TextView tvTanggalMulai;
    @BindView(R.id.event_general_detail_description)
    JustifyTextView tvDescription;
    @BindView(R.id.event_general_detail_image)
    WrapContentDraweeView tvPicture;

//    public static String [] menuList={"Absen","Rundown","Materi","Location"};
//    public static int [] iconId={R.drawable.icon_absen,R.drawable.icon_rundown,R.drawable.icon_materi,R.drawable.icon_location};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);

        if (ab != null)
            ab.setTitle("Event");

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

        String dateTimeStart[]=getIntent().getStringExtra("start_date").split(" ");

        SimpleDateFormat inputFormatStart = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormatStart = new SimpleDateFormat("dd/MM/yyyy");

        String dateStart = null;
        try {
            Date d = inputFormatStart.parse(dateTime[0]);
            dateStart = outputFormatStart.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        tvTanggalMulai.setText("Start Date: " + dateStart+" "+dateTimeStart[1]);

        Uri uri = Uri.parse(Config.KEY_URL_ASSET_EVENT + getIntent().getStringExtra("picture"));

        tvPicture.setImageURI(uri);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_event_general_detail;
    }
}
