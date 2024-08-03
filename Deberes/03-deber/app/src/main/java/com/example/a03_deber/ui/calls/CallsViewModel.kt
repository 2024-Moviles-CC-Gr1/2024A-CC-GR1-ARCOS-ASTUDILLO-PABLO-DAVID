package com.example.a03_deber.ui.calls

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Call(
    val profileImageUrl: String,
    val name: String,
    val time: String,
    val isAnswered: Boolean,
    val isIncoming: Boolean
)

class CallsViewModel : ViewModel() {

    private val _calls = MutableLiveData<List<Call>>().apply {
        value = listOf(
            Call("https://randomuser.me/api/portraits/men/1.jpg", "John Doe", "10:30 AM", true, true),
            Call("https://randomuser.me/api/portraits/women/2.jpg", "Jane Smith", "9:15 AM", false, true),
            Call("https://randomuser.me/api/portraits/men/3.jpg", "Sam Wilson", "2:00 PM", true, false),
            Call("https://randomuser.me/api/portraits/women/4.jpg", "Emily Clark", "11:45 AM", false, true),
            Call("https://randomuser.me/api/portraits/men/5.jpg", "Michael Brown", "1:30 PM", true, true),
            Call("https://randomuser.me/api/portraits/women/6.jpg", "Linda Johnson", "3:15 PM", false, false),
            Call("https://randomuser.me/api/portraits/men/7.jpg", "Robert Davis", "4:00 PM", true, false),
            Call("https://randomuser.me/api/portraits/women/8.jpg", "Patricia Garcia", "5:30 PM", false, true),
            Call("https://randomuser.me/api/portraits/men/9.jpg", "James Rodriguez", "6:45 PM", true, true),
            Call("https://randomuser.me/api/portraits/women/10.jpg", "Mary Martinez", "7:00 PM", false, false),
            Call("https://randomuser.me/api/portraits/men/11.jpg", "Christopher Hernandez", "8:15 PM", true, true),
            Call("https://randomuser.me/api/portraits/women/12.jpg", "Elizabeth Lopez", "9:00 PM", false, true),
            Call("https://randomuser.me/api/portraits/men/13.jpg", "Thomas Hill", "10:00 PM", true, false),
            Call("https://randomuser.me/api/portraits/women/14.jpg", "Barbara Allen", "10:45 PM", false, true),
            Call("https://randomuser.me/api/portraits/men/15.jpg", "David Wright", "11:30 PM", true, true),
            Call("https://randomuser.me/api/portraits/women/16.jpg", "Jennifer Scott", "12:00 AM", false, false),
            Call("https://randomuser.me/api/portraits/men/17.jpg", "William Green", "1:00 AM", true, false),
            Call("https://randomuser.me/api/portraits/women/18.jpg", "Susan Adams", "2:30 AM", false, true),
            Call("https://randomuser.me/api/portraits/men/19.jpg", "Joseph Baker", "3:00 AM", true, true),
            Call("https://randomuser.me/api/portraits/women/20.jpg", "Nancy Gonzalez", "4:15 AM", false, false),
            Call("https://randomuser.me/api/portraits/men/1.jpg", "John Doe", "5:30 AM", true, true),
            Call("https://randomuser.me/api/portraits/women/2.jpg", "Jane Smith", "6:45 AM", false, true),
            Call("https://randomuser.me/api/portraits/men/3.jpg", "Sam Wilson", "7:30 AM", true, false),
            Call("https://randomuser.me/api/portraits/women/4.jpg", "Emily Clark", "8:15 AM", false, true),
            Call("https://randomuser.me/api/portraits/men/5.jpg", "Michael Brown", "9:00 AM", true, true),
            Call("https://randomuser.me/api/portraits/women/6.jpg", "Linda Johnson", "10:00 AM", false, false),
            Call("https://randomuser.me/api/portraits/men/7.jpg", "Robert Davis", "11:15 AM", true, true),
            Call("https://randomuser.me/api/portraits/women/8.jpg", "Patricia Garcia", "12:00 PM", false, true),
            Call("https://randomuser.me/api/portraits/men/9.jpg", "James Rodriguez", "1:30 PM", true, false),
            Call("https://randomuser.me/api/portraits/women/10.jpg", "Mary Martinez", "2:00 PM", false, true),
            Call("https://randomuser.me/api/portraits/men/11.jpg", "Christopher Hernandez", "3:15 PM", true, true),
            Call("https://randomuser.me/api/portraits/women/12.jpg", "Elizabeth Lopez", "4:30 PM", false, false),
            Call("https://randomuser.me/api/portraits/men/13.jpg", "Thomas Hill", "5:45 PM", true, true),
            Call("https://randomuser.me/api/portraits/women/14.jpg", "Barbara Allen", "6:30 PM", false, true),
            Call("https://randomuser.me/api/portraits/men/15.jpg", "David Wright", "7:00 PM", true, false),
            Call("https://randomuser.me/api/portraits/women/16.jpg", "Jennifer Scott", "8:00 PM", false, true),
            Call("https://randomuser.me/api/portraits/men/17.jpg", "William Green", "9:15 PM", true, true),
            Call("https://randomuser.me/api/portraits/women/18.jpg", "Susan Adams", "10:00 PM", false, false),
            Call("https://randomuser.me/api/portraits/men/19.jpg", "Joseph Baker", "11:30 PM", true, false),
            Call("https://randomuser.me/api/portraits/women/20.jpg", "Nancy Gonzalez", "12:00 AM", false, true)

        )
    }
    val calls: LiveData<List<Call>> = _calls
}
