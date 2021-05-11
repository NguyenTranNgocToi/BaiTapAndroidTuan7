package com.example.dataroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ItemDao {
    @Query("SELECT * FROM item")
    List<Item> getAll();
    @Insert
    void insertAll(Item... items);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM item WHERE item.uid = (:Id)")
    User getItem(int Id);
}
