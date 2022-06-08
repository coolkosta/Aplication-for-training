package com.coolkosta.aplicationfortraning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val KEY = "MainActivity"

class MainActivity : AppCompatActivity() {

    /* инициализируем в Activity RecyclerView */
    private lateinit var usersRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uerList: List<User> = listOf(User("Иван", 6),
            User("Николай", 45),
            User("Георгий", 34),
            User("Игорь", 21),
            User("Савелий", 30),
            User("Егор", 67),
            User("Константин", 55),
            User("Александр", 76),
            User("Михаил", 15),
            User("Артем", 87),
            User("Максим", 28),
            User("Егор", 67),
            User("Константин", 55),
            User("Александр", 76),
            User("Михаил", 15),
            User("Артем", 87),
            User("Максим", 28)
        )


        /* настраиваем RecyclerView
        1. ищем по id необходимый RecyclerView
        2. задаем RecyclerView параметры layOutManager-а путем настраивания отображения view
        3. После создания ViewHolder-а и Adapter-а, присваеваем для RecyclerView Adapter */
        usersRecyclerView = findViewById(R.id.user_recycler_view) // 1.
        usersRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) // 2.
        usersRecyclerView.adapter = UserAdapter(uerList) // 3.

    }
}