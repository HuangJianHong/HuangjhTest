package hjhtest.com.cncn.www.huangjhtest.greendao.db.helper;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import hjhtest.com.cncn.www.huangjhtest.greendao.db.UserDao;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.entity.User;

/**
 * Created by  Hjh on 2018/2/6.
 * desc：
 */

public class UserManager {

    //更新
    public static void update(User user) {
        GreenDaoManager.getInstance().getSession().getUserDao().update(user);
    }

    //插入
    public static void insert(User user) {
        GreenDaoManager.getInstance().getSession().getUserDao().insert(user);
    }

    public static void insertOrRepalce(User user) {
        GreenDaoManager.getInstance().getSession().getUserDao().insertOrReplace(user);
    }

    //删除
    public static void delete(User user) {
        GreenDaoManager.getInstance().getSession().getUserDao().delete(user);
    }

    public static void deleteAll() {
        GreenDaoManager.getInstance().getSession().getUserDao().deleteAll();
    }

    //根据userId,删除
    public static void deleteUser(String userId) {
        QueryBuilder<User> builder = GreenDaoManager.getInstance().getSession().getUserDao().queryBuilder();
        builder.where(UserDao.Properties.UserId.eq(userId));
    }

    //查询
    public static List<User> queryAll() {
        return GreenDaoManager.getInstance().getSession().getUserDao().loadAll();
    }

    //根据ID查询
    public static User queryById(long rowId) {
        return GreenDaoManager.getInstance().getSession().getUserDao().loadByRowId(rowId);
    }


    //查询年龄大于10的用户,不包含10
    public static List<User> queryCondition() {
        UserDao userDao = GreenDaoManager.getInstance().getSession().getUserDao();
        return userDao.queryBuilder().where(UserDao.Properties.Age.gt(10)).build().list();
    }

    //查询年龄大于等于10的用户
    public static  List<User> queryAge10() {
        UserDao userDao = GreenDaoManager.getInstance().getSession().getUserDao();
        return userDao.queryRaw("where AGE >= ?", "10");
    }

    public static  List<User> queryUserId(String userId) {
        QueryBuilder<User> builder = GreenDaoManager.getInstance().getSession().getUserDao().queryBuilder();
        return  builder.where(UserDao.Properties.UserId.eq(userId)).build().list();
    }


}
