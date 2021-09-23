package com.example.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    lateinit var usuarios:ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var database = FirebaseDatabase.getInstance()
        var myref = database.reference
        usuarios = arrayListOf()

        myref.child("Usuario").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(datasnapshot: DataSnapshot) {
              if (datasnapshot.exists()){

                  for (snapshot in datasnapshot.children){
                        var usu = snapshot.getValue(User::class.java)

                        usuarios.add(usu!!)
                  }

              }
                mostrarUsuario()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }

    private fun mostrarUsuario() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val adapter  = UserAdapter(usuarios)
        rvUser.adapter = adapter
    }
}