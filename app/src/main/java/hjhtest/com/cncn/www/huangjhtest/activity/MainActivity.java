package hjhtest.com.cncn.www.huangjhtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import javax.inject.Inject;

import hjhtest.com.cncn.www.huangjhtest.R;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;
import hjhtest.com.cncn.www.huangjhtest.dagger.component.MainComponent;
import hjhtest.com.cncn.www.huangjhtest.greendao.GreenDaoActivity;


public class MainActivity extends AppCompatActivity {

    @Inject
    Poetry mPoetry;

    @Inject
    Gson mGson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent.getInstance().inject(this);

        TextView tvTest = (TextView) findViewById(R.id.tvTest);
        String json = mGson.toJson(mPoetry);
        String text =json +", mPoetry: " + mPoetry;
        tvTest.setText(text);

        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OtherActivity.class));
            }
        });


        findViewById(R.id.button_dao).setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GreenDaoActivity.class)));
    }

}
