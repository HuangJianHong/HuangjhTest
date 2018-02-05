package hjhtest.com.cncn.www.huangjhtest.greendao.bean;

/**
 * Created by  Hjh on 2018/2/5.
 * desc：
 */

public class UserBean {

    private String userId;

    private String userName;

    private int age;

    public UserBean(String userId, String userName, int age) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
