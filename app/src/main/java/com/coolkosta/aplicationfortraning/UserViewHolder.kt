package com.coolkosta.aplicationfortraning

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/* Создаем наш класс ViewHolder, и наследуем
от RecyclerView.ViewHolder, в ктором присваеваем параметрыр View
 */

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /* Далее инициализируем item-ы из user_list_item с помощью поиска findViewById,
       но так как мы не находимся в активити, мы ищем id через парамерт View (itemView).
       Делаем приватными. */

    private val nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
    private val ageTextView: TextView = itemView.findViewById(R.id.age_text_view)


    /* Создаем функцию bind для размещения данных на ViewHolder.
    В параметры функции мы пишем данные которые будут использованы из data class-а User */

    fun bind(user: User) {

        /* Здесь настраиваем само отображение TextView. */

        nameTextView.text = "Имя пользователя ${user.name}"
        ageTextView.text = "Возраст пользователя ${user.age}"

    }

}