package com.example.kontactroom.db

import androidx.room.*
import com.example.kontactroom.user.User

@Dao
interface DataBaseServis {

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<User>

    @Query("SELECT id FROM USER WHERE name =:uName")
    fun getUserById(uName: String): Int

    @Insert
    fun addUser(user: User)

    // user1 1 doniyor2 user2 2 farrux
    @Update
    fun editUser(user: User)

    @Delete
    fun deleteUser(user: User)

}