package hjhtest.com.cncn.www.huangjhtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

import hjhtest.com.cncn.www.huangjhtest.R;
import hjhtest.com.cncn.www.huangjhtest.app.MainApplication;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;
import hjhtest.com.cncn.www.huangjhtest.dagger.qualifier.PoetryQualifier;

public class AActivity extends AppCompatActivity {

    @Inject
    Gson mGson;

    @PoetryQualifier("A")
    @Inject
    Poetry mPoetry;

    @PoetryQualifier("B")
    @Inject
    Poetry mPoetryB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainApplication.getInstance().getAcomponent().inject(this);

        TextView tvTest = (TextView) findViewById(R.id.tvTest);
        String text = mPoetry.getPemo()+ " mPoetryA: " + mPoetry + mPoetryB.getPemo() +",mPoetryB: "+ mPoetryB
                +(mGson == null ? "Gson没被注入" : "Gson已经被注入");

        tvTest.setText(text);

        tvTest.setOnClickListener(v -> startActivity(new Intent(AActivity.this, BActivity.class )));
    }

}
