package com.example.realtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database.reference.child("users")
        setup()
    }

    private fun setup(){
        btn_registrar.setOnClickListener {
            val name = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            var sexo = if (masculinoCheckBox.isChecked) "masculino" else "femenino"

           if (name.isNotEmpty() && email.isNotEmpty() && sexo.isNotEmpty()){
               val user = User(name, email, sexo)
               database.child(name).setValue(user)
               Toast.makeText(this, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show()
           }else{
               Toast.makeText(this, "Error al ingresar los datos intente nuevamente", Toast.LENGTH_SHORT).show()
           }
        }
    }

    data class User(val username: String?, val email: String?, val sexo:String)
}