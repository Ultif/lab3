package com.kudriavcev.android.lab3.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kudriavcev.android.lab3.util.Constants.TASK_TABLE
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TASK_TABLE)
data class TaskEntry(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var priority: Int,
    var timestamp: Long
): Parcelable