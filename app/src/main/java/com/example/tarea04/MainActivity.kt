package com.example.tarea04

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Interfaz agregar nueva tarea
        //setContentView(R.layout.add_task_layout)

        // Interfaz vista tarea
        setContentView(R.layout.task_layout)

        //setContentView(R.layout.task_list_layout)
    }
}
