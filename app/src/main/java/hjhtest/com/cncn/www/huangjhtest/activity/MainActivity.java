package hjhtest.com.cncn.www.huangjhtest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import hjhtest.com.cncn.www.huangjhtest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvTest = (TextView) findViewById(R.id.tvTest);

        tvTest.setOnClickListener(v -> {
            Toast.makeText(this, "showSomething", Toast.LENGTH_SHORT).show();
        });
    }

}
