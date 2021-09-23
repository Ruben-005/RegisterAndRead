package com.example.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var database = FirebaseDatabase.getInstance()
        var myref = database.reference

        myref.child("Usuario").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(datasnapshot: DataSnapshot) {
                for (it in datasnapshot.children){
                    var us = it.getValue(User::class.java)

                    tv_texto.append(us!!.username)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}