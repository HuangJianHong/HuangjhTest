package hjhtest.com.cncn.www.huangjhtest.greendao.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import hjhtest.com.cncn.www.huangjhtest.greendao.db.DaoMaster;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.UserDao;

/**
 * Created by  Hjh on 2018/2/7.
 * desc： 重写onUpgrade方法， 用于数据库升级 迁移数据
 */

public class DaoOpenHelper extends DaoMaster.DevOpenHelper {

    public DaoOpenHelper(Context context, String name) {
        super(context, name);
    }

    public DaoOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
//        super.onUpgrade(db, oldVersion, newVersion);   //默认情况下的数据库升级，会移除掉旧表，重新再创建表数据
        Log.i("greenDAO", "Upgrading schema from version "
                + oldVersion
                + " to "
                + newVersion
                + " by migrating all tables data");

        MigrationHelper.getInstance().migrate(db, UserDao.class);
    }


}
