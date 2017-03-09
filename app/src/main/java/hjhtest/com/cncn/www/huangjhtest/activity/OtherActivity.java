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

public class OtherActivity extends AppCompatActivity {

    @Inject
    Poetry mPoetry;

    @Inject
    Gson mGson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        MainComponent.getInstance().inject(this);
        initView();
    }

    private void initView() {
        TextView tvTest = (TextView) findViewById(R.id.tvTest);
        String json = mGson.toJson(mPoetry);
        String text =json +", mPoetry: " + mPoetry;
        tvTest.setText(text);

        tvTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtherActivity.this, AActivity.class));
            }
        });
    }


}
