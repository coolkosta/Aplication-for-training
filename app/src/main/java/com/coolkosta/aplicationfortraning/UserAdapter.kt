package com.coolkosta.aplicationfortraning

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/* После создания ViewHolder, создаем Adapter, который наследуется от
 RecyclerView.Adapter, который принимает в себя ViewHolder.
 После производим Implementation для переопределния 3 функций
 onCreateViewHolder, onBindingViewHolder, getItemCount
 В параметрых UserAdapter создаем переменную для работы со списком.

 */

class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserViewHolder>() {


    /* 2. onCreateViewHolder создает отдельный объект для ViewHolder-a. данная функция требует
    вернуть ViewHolder(У нас это UserViewHolder) */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        /* Сначала нужно создать переменную, которая будет содержать макет для ViewHolder
        * onCreateViewHolder создает абстрактную View (в нашем случае item_list_item).
        * Используем LayoutInflater, который берет экземпляр макета XML и делает его View объектом
        * в коде. После возвращаем во ViewHolder созданный макет View
        */

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return UserViewHolder(itemView)
    }

    /* 3. В функции onBindViewHolder создаем переменную для каждого объекта из списка,
    для определения его позици в списке и отрисовке.
    Далее вызвыаем функцию bind из созданного ViewHolder-а, для того чтобы отображались данные,
    в каждом объекте из списка правильно
    */
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }


    /* 1. Работаем сначала с этой функицей. getItemCount просит вернуть колличество
     элементов в списке */
    override fun getItemCount(): Int {
        return userList.size // Возвращаем колличество эл-ов списка
    }
}
