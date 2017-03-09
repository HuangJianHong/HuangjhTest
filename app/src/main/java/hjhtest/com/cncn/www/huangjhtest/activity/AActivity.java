package hjhtest.com.cncn.www.huangjhtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

import hjhtest.com.cncn.www.huangjhtest.R;
import hjhtest.com.cncn.www.huangjhtest.app.MainApplication;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;

public class AActivity extends AppCompatActivity {

    @Inject
    Gson mGson;

    @Inject
    Poetry mPoetry;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        MainApplication.getInstance().getAcomponent().inject(this);



        TextView tvTest = (TextView) findViewById(R.id.tvTest);
        String text = mPoetry.getPemo()+",mPoetry:"+mPoetry+(mGson == null ? "Gson没被注入" : "Gson已经被注入");
        tvTest.setText(text);
    }

}
