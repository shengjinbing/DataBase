package scut.carson_ho.database_demo.activitys;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.List;

import scut.carson_ho.database_demo.R;
import scut.carson_ho.database_demo.adapters.CusAdapter;
import scut.carson_ho.database_demo.bean.UserBean;
import scut.carson_ho.database_demo.room.AppDatabase;
import scut.carson_ho.database_demo.room.User;
import scut.carson_ho.database_demo.room.UserViewModel;
import scut.carson_ho.database_demo.room.WordListAdapter;
import scut.carson_ho.database_demo.sqlite.SqliteHelper;

public class SqliteActivity extends AppCompatActivity implements View.OnClickListener {
    private Button instablish;
    private Button insert;
    private Button upgrade;
    private Button modify;
    private Button delete;
    private Button query;
    private Button delete_database;
    private EditText mEt;

    private CusAdapter mWordListAdapter;
    private SqliteHelper mSqliteHelper;

    private static final String DATABASE = "sqlite_database";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        //绑定按钮
        instablish = (Button) findViewById(R.id.instablish);
        insert = (Button) findViewById(R.id.insert);
        upgrade = (Button) findViewById(R.id.upgrade);
        modify = (Button) findViewById(R.id.modify);
        delete = (Button) findViewById(R.id.delete);
        query = (Button) findViewById(R.id.query);
        delete_database = (Button) findViewById(R.id.delete_database);
        mEt = (EditText) findViewById(R.id.et);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyc);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mWordListAdapter = new CusAdapter(this);
        recyclerView.setAdapter(mWordListAdapter);
    }

    private void initData() {
    }

    private void initListener() {
        //设置监听器
        instablish.setOnClickListener(this);
        insert.setOnClickListener(this);
        upgrade.setOnClickListener(this);
        modify.setOnClickListener(this);
        delete.setOnClickListener(this);
        query.setOnClickListener(this);
        delete_database.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = mEt.getText().toString().trim();
        switch (v.getId()) {
            case R.id.instablish:
                //点击创建数据库库
                mSqliteHelper = SqliteHelper.getInstance();
                mSqliteHelper.initSqlite(this,DATABASE);
                break;
            case R.id.upgrade:
                //点击更新数据
                mSqliteHelper.onUpgrade(this, DATABASE, 2);
                break;
            case R.id.insert:
                //点击插入数据到数据库
                UserBean userBean = new UserBean();
                userBean.setId(Integer.parseInt(id));
                userBean.setName(id + "李四");
                mSqliteHelper.insert(userBean);
                break;
            case R.id.query:
                //点击查询数据库
                mWordListAdapter.setWords(mSqliteHelper.query());
                break;
            case R.id.modify:
                //点击修改数据
                UserBean modify = new UserBean();
                modify.setId(Integer.parseInt(id));
                modify.setName(id + "王五");
                mSqliteHelper.modify(modify);
                break;
            case R.id.delete:
                //点击删除数据
                mSqliteHelper.delete(id);
                break;
            case R.id.delete_database:
                //点击删除数据库
                SQLiteDatabase database = mSqliteHelper.getWritableDatabase();
                String path = database.getPath();
                mSqliteHelper.deleteDataBase(new File(path));
                break;
            default:
                break;

        }
    }
}
