package scut.carson_ho.database_demo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Method;
import java.util.List;

import scut.carson_ho.database_demo.activitys.GreenDaoActivity;
import scut.carson_ho.database_demo.activitys.RoomActivity;
import scut.carson_ho.database_demo.activitys.SqliteActivity;
import scut.carson_ho.database_demo.room.AppDatabase;
import scut.carson_ho.database_demo.room.User;
import scut.carson_ho.database_demo.room.UserViewModel;
import scut.carson_ho.database_demo.room.WordListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sqlite(View view) {
        startActivity(new Intent(this, SqliteActivity.class));
    }

    public void room(View view) {
        startActivity(new Intent(this, RoomActivity.class));
    }

    public void greenDao(View view) {
        startActivity(new Intent(this, GreenDaoActivity.class));
    }
}