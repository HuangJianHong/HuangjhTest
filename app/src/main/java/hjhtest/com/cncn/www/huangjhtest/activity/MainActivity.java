package hjhtest.com.cncn.www.huangjhtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import hjhtest.com.cncn.www.huangjhtest.R;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;
import hjhtest.com.cncn.www.huangjhtest.dagger.component.DaggerMainComponent;


public class MainActivity extends AppCompatActivity {

    @Inject
    Poetry mPoetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent.builder().build().inject(this);



        TextView tvTest = (TextView) findViewById(R.id.tvTest);
        tvTest.setText(mPoetry.getPemo());

        tvTest.setOnClickListener(v -> {
            Toast.makeText(this, "showSomething", Toast.LENGTH_SHORT).show();
        });
    }

}
