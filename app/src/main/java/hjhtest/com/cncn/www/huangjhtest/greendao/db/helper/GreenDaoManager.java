package hjhtest.com.cncn.www.huangjhtest.greendao.db.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import hjhtest.com.cncn.www.huangjhtest.greendao.db.DaoMaster;
import hjhtest.com.cncn.www.huangjhtest.greendao.db.DaoSession;

/**
 * Created by  Hjh on 2018/2/5.
 * desc：
 */

public class GreenDaoManager {
    private static DaoOpenHelper mOpenHelper;
    private static SQLiteDatabase db;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static volatile GreenDaoManager mInstance = null;
    private static final String DB_NAME = "User.db";

    private GreenDaoManager() {
    }

    public static void init(Context context) {
        mOpenHelper = new DaoOpenHelper(context, DB_NAME, null);
        db = mOpenHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }
}