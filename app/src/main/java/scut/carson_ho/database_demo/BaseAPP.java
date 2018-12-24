package scut.carson_ho.database_demo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import scut.carson_ho.database_demo.greendao.utils.DaoManager;
import scut.carson_ho.database_demo.greendao.DaoMaster;
import scut.carson_ho.database_demo.greendao.DaoSession;

/**
 * Created by lixiang
 * on 2018/12/24
 */
public class BaseAPP extends Application{
    public static final String DB_NAME = "greendao.db";
    private static DaoSession mDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoManager.getInstance().init(this);
        //initGreenDao();
    }
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DB_NAME);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getmDaoSession() {
        return mDaoSession;
    }
}
