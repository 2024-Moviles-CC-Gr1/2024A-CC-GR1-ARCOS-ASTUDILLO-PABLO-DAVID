package com.example.a03_deber.ui.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Chat(val imageUrl: String, val name: String, val lastMessage: String)

class ChatsViewModel : ViewModel() {

    private val _chats = MutableLiveData<List<Chat>>().apply {
        value = listOf(
            Chat("https://randomuser.me/api/portraits/men/1.jpg", "John Doe", "Hey, how are you?"),
            Chat("https://randomuser.me/api/portraits/women/2.jpg", "Jane Smith", "Let's catch up!"),
            Chat("https://randomuser.me/api/portraits/men/3.jpg", "Sam Wilson", "Meeting at 3 PM."),
            Chat("https://randomuser.me/api/portraits/women/4.jpg", "Emily Clark", "See you soon!"),
            Chat("https://randomuser.me/api/portraits/men/5.jpg", "Michael Brown", "What's up?"),
            Chat("https://randomuser.me/api/portraits/women/6.jpg", "Linda Johnson", "Call me back."),
            Chat("https://randomuser.me/api/portraits/men/7.jpg", "Robert Davis", "Got the documents."),
            Chat("https://randomuser.me/api/portraits/women/8.jpg", "Patricia Garcia", "Happy Birthday!"),
            Chat("https://randomuser.me/api/portraits/men/9.jpg", "James Rodriguez", "Let's go for a run."),
            Chat("https://randomuser.me/api/portraits/women/10.jpg", "Mary Martinez", "Thank you!"),
            Chat("https://randomuser.me/api/portraits/men/11.jpg", "Christopher Hernandez", "Good job!"),
            Chat("https://randomuser.me/api/portraits/women/12.jpg", "Elizabeth Lopez", "See you at dinner."),
            Chat("https://randomuser.me/api/portraits/men/13.jpg", "Thomas Hill", "Check your email."),
            Chat("https://randomuser.me/api/portraits/women/14.jpg", "Barbara Allen", "Congrats on your promotion!"),
            Chat("https://randomuser.me/api/portraits/men/15.jpg", "David Wright", "I'll be there."),
            Chat("https://randomuser.me/api/portraits/women/16.jpg", "Jennifer Scott", "Meeting rescheduled."),
            Chat("https://randomuser.me/api/portraits/men/17.jpg", "William Green", "Happy New Year!"),
            Chat("https://randomuser.me/api/portraits/women/18.jpg", "Susan Adams", "Let's discuss tomorrow."),
            Chat("https://randomuser.me/api/portraits/men/19.jpg", "Joseph Baker", "See you later."),
            Chat("https://randomuser.me/api/portraits/women/20.jpg", "Nancy Gonzalez", "Can you help me?"),
            Chat("https://randomuser.me/api/portraits/men/1.jpg", "John Doe", "Hey, how are you?"),
            Chat("https://randomuser.me/api/portraits/women/2.jpg", "Jane Smith", "Let's catch up!"),
            Chat("https://randomuser.me/api/portraits/men/3.jpg", "Sam Wilson", "Meeting at 3 PM."),
            Chat("https://randomuser.me/api/portraits/women/4.jpg", "Emily Clark", "See you soon!"),
            Chat("https://randomuser.me/api/portraits/men/5.jpg", "Michael Brown", "What's up?"),
            Chat("https://randomuser.me/api/portraits/women/6.jpg", "Linda Johnson", "Call me back."),
            Chat("https://randomuser.me/api/portraits/men/7.jpg", "Robert Davis", "Got the documents."),
            Chat("https://randomuser.me/api/portraits/women/8.jpg", "Patricia Garcia", "Happy Birthday!"),
            Chat("https://randomuser.me/api/portraits/men/9.jpg", "James Rodriguez", "Let's go for a run."),
            Chat("https://randomuser.me/api/portraits/women/10.jpg", "Mary Martinez", "Thank you!"),
            Chat("https://randomuser.me/api/portraits/men/11.jpg", "Christopher Hernandez", "Good job!"),
            Chat("https://randomuser.me/api/portraits/women/12.jpg", "Elizabeth Lopez", "See you at dinner."),
            Chat("https://randomuser.me/api/portraits/men/13.jpg", "Thomas Hill", "Check your email."),
            Chat("https://randomuser.me/api/portraits/women/14.jpg", "Barbara Allen", "Congrats on your promotion!"),
            Chat("https://randomuser.me/api/portraits/men/15.jpg", "David Wright", "I'll be there."),
            Chat("https://randomuser.me/api/portraits/women/16.jpg", "Jennifer Scott", "Meeting rescheduled."),
            Chat("https://randomuser.me/api/portraits/men/17.jpg", "William Green", "Happy New Year!"),
            Chat("https://randomuser.me/api/portraits/women/18.jpg", "Susan Adams", "Let's discuss tomorrow."),
            Chat("https://randomuser.me/api/portraits/men/19.jpg", "Joseph Baker", "See you later."),
            Chat("https://randomuser.me/api/portraits/women/20.jpg", "Nancy Gonzalez", "Can you help me?"),
            Chat("https://randomuser.me/api/portraits/men/1.jpg", "John Doe", "Hey, how are you?"),
            Chat("https://randomuser.me/api/portraits/women/2.jpg", "Jane Smith", "Let's catch up!"),
            Chat("https://randomuser.me/api/portraits/men/3.jpg", "Sam Wilson", "Meeting at 3 PM."),
            Chat("https://randomuser.me/api/portraits/women/4.jpg", "Emily Clark", "See you soon!"),
            Chat("https://randomuser.me/api/portraits/men/5.jpg", "Michael Brown", "What's up?"),
            Chat("https://randomuser.me/api/portraits/women/6.jpg", "Linda Johnson", "Call me back."),
            Chat("https://randomuser.me/api/portraits/men/7.jpg", "Robert Davis", "Got the documents."),
            Chat("https://randomuser.me/api/portraits/women/8.jpg", "Patricia Garcia", "Happy Birthday!"),
            Chat("https://randomuser.me/api/portraits/men/9.jpg", "James Rodriguez", "Let's go for a run."),
            Chat("https://randomuser.me/api/portraits/women/10.jpg", "Mary Martinez", "Thank you!"),
            Chat("https://randomuser.me/api/portraits/men/11.jpg", "Christopher Hernandez", "Good job!"),
            Chat("https://randomuser.me/api/portraits/women/12.jpg", "Elizabeth Lopez", "See you at dinner."),
            Chat("https://randomuser.me/api/portraits/men/13.jpg", "Thomas Hill", "Check your email."),
            Chat("https://randomuser.me/api/portraits/women/14.jpg", "Barbara Allen", "Congrats on your promotion!"),
            Chat("https://randomuser.me/api/portraits/men/15.jpg", "David Wright", "I'll be there."),
            Chat("https://randomuser.me/api/portraits/women/16.jpg", "Jennifer Scott", "Meeting rescheduled."),
            Chat("https://randomuser.me/api/portraits/men/17.jpg", "William Green", "Happy New Year!"),
            Chat("https://randomuser.me/api/portraits/women/18.jpg", "Susan Adams", "Let's discuss tomorrow."),
            Chat("https://randomuser.me/api/portraits/men/19.jpg", "Joseph Baker", "See you later."),
            Chat("https://randomuser.me/api/portraits/women/20.jpg", "Nancy Gonzalez", "Can you help me?")



        )
    }
    val chats: LiveData<List<Chat>> = _chats
}
