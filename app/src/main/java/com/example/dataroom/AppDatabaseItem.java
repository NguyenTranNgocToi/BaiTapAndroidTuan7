package com.example.dataroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Item.class}, version = 2)
public abstract class AppDatabaseItem extends RoomDatabase {
    public abstract ItemDao itemDao();
}
