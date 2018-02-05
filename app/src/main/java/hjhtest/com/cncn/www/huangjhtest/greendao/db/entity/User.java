package hjhtest.com.cncn.www.huangjhtest.greendao.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by  Hjh on 2018/2/5.
 * desc：
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private long id;

    private String userId;

    private String userName;

    private int age;

    @Generated(hash = 1334185703)
    public User(long id, String userId, String userName, int age) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
