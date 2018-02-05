package hjhtest.com.cncn.www.huangjhtest.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import hjhtest.com.cncn.www.huangjhtest.R;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.UserDao;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.helper.GreenDaoManager;

public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_green_dao);


        userDao = GreenDaoManager.getInstance().getSession().getUserDao();

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:   //add

                break;

            case R.id.button2:  //delete
                break;

            case R.id.button3:  //改
                break;

            case R.id.button4:  //查
                break;
        }

    }
}
