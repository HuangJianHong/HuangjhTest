package hjhtest.com.cncn.www.huangjhtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

import hjhtest.com.cncn.www.huangjhtest.R;
import hjhtest.com.cncn.www.huangjhtest.dagger.Poetry;
import hjhtest.com.cncn.www.huangjhtest.dagger.component.DaggerBComponent;

public class BActivity extends Activity {

    @Named("A")
    @Inject
    Poetry poetry;

    @Named("B")
    @Inject
    Poetry poetryB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        DaggerBComponent.builder().build().inject(this);

        TextView tvName = (TextView) findViewById(R.id.tv_name);
        tvName.setText(poetry.getPemo() + " --- "  + poetryB.getPemo()   +  "\n" +poetry + " === "  + poetryB);
    }
}
