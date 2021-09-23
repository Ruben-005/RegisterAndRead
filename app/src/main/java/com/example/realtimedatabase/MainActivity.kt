package com.example.realtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var database:DatabaseReference
    lateinit var usuario:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database.reference
        setup()
    }

    private fun setup(){
        btn_registrar.setOnClickListener {
            val name = usernameEditText.text.toString()
            val email = emailEditText.text.toString()
            var sexo = if (masculinoCheckBox.isChecked) "masculino" else "femenino"

            SubirDatosFireBase(name, email, sexo)
        }

        btn_Info.setOnClickListener {
            var int = Intent(this,  InfoActivity::class.java)

            startActivity(int)
        }
    }

    private fun SubirDatosFireBase(name: String, email: String, sexo: String) {
        if (name.isNotEmpty() && email.isNotEmpty() && sexo.isNotEmpty()) {
            val user = User(name, email, sexo)
            database.child("Usuario").push().setValue(user)
            Toast.makeText(this, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(
                this,
                "Error al ingresar los datos intente nuevamente",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}