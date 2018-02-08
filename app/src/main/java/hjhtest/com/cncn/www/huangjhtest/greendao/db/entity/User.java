package hjhtest.com.cncn.www.huangjhtest.greendao.db.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by  Hjh on 2018/2/5.
 * desc： 数据库实体表
 */
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;

    private String userId;

    private String userName;

    private int age;

    private Integer score;


    @Generated(hash = 1162692669)
    public User(Long id, String userId, String userName, int age, Integer score) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.score = score;
    }


    @Generated(hash = 586692638)
    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
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


    public Integer getScore() {
        return this.score;
    }


    public void setScore(Integer score) {
        this.score = score;
    }
}

