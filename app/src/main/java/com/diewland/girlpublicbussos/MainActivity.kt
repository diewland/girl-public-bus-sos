package com.diewland.girlpublicbussos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSos = findViewById<Button>(R.id.btn_sos)
        btnSos.setOnClickListener {
            Toast.makeText(this@MainActivity, "Some message", Toast.LENGTH_SHORT).show()
        }

    }
}
