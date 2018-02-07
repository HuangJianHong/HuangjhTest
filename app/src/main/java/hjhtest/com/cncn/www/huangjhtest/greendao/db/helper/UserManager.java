package hjhtest.com.cncn.www.huangjhtest.greendao.db.helper;

import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxDao;

import java.util.List;

import hjhtest.com.cncn.www.huangjhtest.greendao.db.UserDao;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.entity.User;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by  Hjh on 2018/2/6.
 * desc：UserDao数据操作工具
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

    public static void insertOrReplace(User user) {
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

    //查询所有
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
    public static List<User> queryAge10() {
        UserDao userDao = GreenDaoManager.getInstance().getSession().getUserDao();
        return userDao.queryRaw("where AGE >= ?", "10");
    }

    public static List<User> queryUserId(String userId) {
        QueryBuilder<User> builder = GreenDaoManager.getInstance().getSession().getUserDao().queryBuilder();
        return builder.where(UserDao.Properties.UserId.eq(userId)).build().list();
    }

    /**
     * 当表中存在多个对象是， 会崩溃;
     *
     * @param userId id
     * @return 返回查询到单一User对象， 可能为null,需要做null判断
     */
    public static User queryUserIdOne(String userId) {
        try {
            QueryBuilder<User> builder = GreenDaoManager.getInstance().getSession().getUserDao().queryBuilder();
            builder.where(UserDao.Properties.UserId.eq(userId));
            builder.orderAsc(UserDao.Properties.Id);     //降序
            return builder.unique();                     //如果数据库中存在多个userId， 则会导致崩溃， 如果没有回返回空;
        }catch(Exception e) {
            Log.e("builder.unique", e.getLocalizedMessage());
        }
        return  null;
    }

    //RxDao
    public static void rxInsert(User user) {
        RxDao userDao = GreenDaoManager.getInstance().getSession().getUserDao().rx();
        userDao.insert(user).observeOn(AndroidSchedulers.mainThread()).subscribe(o -> Log.i("RxDao", "insert success"));
    }

}
