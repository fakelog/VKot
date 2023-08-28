package ru.fakelog.vkot.core.data.users.data_source.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "users", primaryKeys = ["id"])
class UserEntity (

    @ColumnInfo(name = "id")
    val id: Long? = null,

    @ColumnInfo(name = "first_name")
    val first_name: String? = null,

)