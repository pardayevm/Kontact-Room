package com.example.kontactroom.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    var name: String? = null,
    var phoneNumber: String? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
) : java.io.Serializable