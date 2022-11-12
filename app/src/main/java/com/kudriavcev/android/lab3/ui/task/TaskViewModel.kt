package com.kudriavcev.android.lab3.ui.task

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kudriavcev.android.lab3.data.TaskRepository
import com.kudriavcev.android.lab3.data.local.TaskEntry

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository : TaskRepository
) : ViewModel(){

    val getAllTasks = repository.getAllTasks()
    val getAllPriorityTasks = repository.getAllPriorityTasks()

    fun insert(taskEntry: TaskEntry) = viewModelScope.launch {
        repository.insert(taskEntry)
    }

    fun delete(taskEntry: TaskEntry) = viewModelScope.launch{
        repository.deleteItem(taskEntry)
    }

    fun update(taskEntry: TaskEntry) = viewModelScope.launch{
        repository.updateData(taskEntry)
    }

    fun deleteAll() = viewModelScope.launch{
        repository.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<TaskEntry>> {
        return repository.searchDatabase(searchQuery)
    }

}