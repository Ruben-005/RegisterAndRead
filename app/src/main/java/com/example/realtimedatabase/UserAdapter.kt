package com.example.realtimedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val users:ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return UserHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.render(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }


    class UserHolder(val view: View):RecyclerView.ViewHolder(view){
        fun render(user: User){
            view.tv_nombre.text = user.username
            view.tv_sexo.text = user.sexo
            view.tv_email.text = user.email
            view.setOnClickListener {
                Toast.makeText(view.context, "El email del usuario es ${user.email}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}