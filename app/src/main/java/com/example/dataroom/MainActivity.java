package com.example.dataroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    UserDao userDao;
    List<User> users;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList  idlist, lnameList;
//    ArrayList fnameList;
    TextView txtname;
    Button btnAdd, btnRemove, btnCancel;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        userDao = db.userDao();
        users = new ArrayList<>();


//        userDao.insertAll(new User("Nguyễn","tới"));
//        userDao.insertAll(user2);

//        users = userDao.getAll();
        txtname = findViewById(R.id.txtname);
        btnAdd = findViewById(R.id.button);
        btnRemove = findViewById(R.id.button2);
        btnCancel = findViewById(R.id.button3);
        listView = findViewById(R.id.listview);
//        fnameList = new ArrayList();
        lnameList = new ArrayList();
        idlist = new ArrayList();
        getListName();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lnameList);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDao.insertAll(new User(txtname.getText().toString()));
                getListName();
                adapter.notifyDataSetChanged();

            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userDao.delete(userDao.getUser((Integer) idlist.get(index)));
                getListName();
                adapter.notifyDataSetChanged();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }
        });
    }


    private ArrayList getListName() {
//        fnameList.clear();
        lnameList.clear();
        idlist.clear();
        for (Iterator iterator = userDao.getAll().iterator(); iterator.hasNext(); ) {
            User user = (User) iterator.next();
//            fnameList.add(user.getFirstName());
            lnameList.add(user.getLastName());
            idlist.add(user.getUid());
        }
        return lnameList;
    }

}
