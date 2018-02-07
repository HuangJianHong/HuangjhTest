package hjhtest.com.cncn.www.huangjhtest.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import hjhtest.com.cncn.www.huangjhtest.R;
import hjhtest.com.cncn.www.huangjhtest.greendao.bean.UserBean;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.entity.User;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.helper.UserManager;

public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_green_dao);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);

        tvQuery = (TextView) findViewById(R.id.tvQuery);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:   //add
                add();
                break;

            case R.id.button2:  //delete
                UserManager.deleteAll();
                break;

            case R.id.button3:  //改
                update("102");
                break;

            case R.id.button4:  //查找全部
                List<User> users = UserManager.queryAll();
                for (int i = 0; i < users.size(); i++) {
                    tvQuery.append(users.get(i).toString());
                }
                break;

            case R.id.button5:  //查找年龄>= 10
                List<User> users2 = UserManager.queryAge10();
                for (int i = 0; i < users2.size(); i++) {
                    tvQuery.append(users2.get(i).toString());
                }
                break;
            case R.id.button6:  //查找UserId =100;
                List<User> users1 = UserManager.queryUserId("100");
                for (int i = 0; i < users1.size(); i++) {
                    tvQuery.append(users1.get(i).toString());
                }
                break;
            case R.id.button7:
                tvQuery.setText("");
                break;
        }

    }

    private void update(String id) {
        if (UserManager.queryUserIdOne(id) != null) {
            User hong = new User(UserManager.queryUserIdOne(id).getId(), "103", "小红", 18);
            UserManager.update(hong);
        }
    }

    private void add() {
        UserBean xiaoming = new UserBean("100", "小明", 10);
        UserBean xiaohua = new UserBean("101", "小花", 8);
        UserBean xiaohong = new UserBean("102", "小红", 15);

        if (UserManager.queryUserIdOne("100") != null) {
            User ming = new User(UserManager.queryUserIdOne("100").getId(), xiaoming.getUserId(), xiaoming.getUserName(), xiaoming.getAge());
            UserManager.insertOrReplace(ming);
        }else {
            User ming = new User(null, xiaoming.getUserId(), xiaoming.getUserName(), xiaoming.getAge());
            UserManager.insert(ming);
        }

        if (UserManager.queryUserIdOne("101") != null) {
            User hua = new User(UserManager.queryUserIdOne("101").getId(), xiaohua.getUserId(), xiaohua.getUserName(), xiaohua.getAge());
            UserManager.insertOrReplace(hua);
        }else {
            User hua = new User(null, xiaohua.getUserId(), xiaohua.getUserName(), xiaohua.getAge());
            UserManager.insertOrReplace(hua);
        }

        if (UserManager.queryUserIdOne("102") != null) {
            User hong = new User(UserManager.queryUserIdOne("102").getId(), xiaohong.getUserId(), xiaohong.getUserName(), xiaohong.getAge());
            UserManager.update(hong);
        }else {
            User hong = new User(null, xiaohong.getUserId(), xiaohong.getUserName(), xiaohong.getAge());
            UserManager.insert(hong);
        }
    }
}
