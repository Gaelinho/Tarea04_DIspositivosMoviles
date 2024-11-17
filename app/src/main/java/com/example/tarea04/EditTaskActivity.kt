package com.example.tarea04

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.ComponentActivity

class EditTaskActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_task_layout)

        val taskName = intent.getStringExtra("taskName")
        val taskSubject = intent.getStringExtra("taskSubject")
        val taskDate = intent.getStringExtra("taskDate")
        val taskTime = intent.getStringExtra("taskTime")
        val taskDescription = intent.getStringExtra("taskDescription")
        val taskPriority = intent.getBooleanExtra("taskPriority", false)
        val position = intent.getIntExtra("position", -1)

        val name = findViewById<EditText>(R.id.task_name)
        val subject = findViewById<Spinner>(R.id.spinner_task_subject)
        val date = findViewById<EditText>(R.id.edit_due_date)
        val time = findViewById<EditText>(R.id.time)
        val description = findViewById<EditText>(R.id.task_desc)
        val priority = findViewById<CheckBox>(R.id.checkBox)

        val subjects = arrayOf("Dispositivos Moviles", "Compiladores", "Complejidad Computacional", "Redes de Computadoras")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subject.adapter = adapter

        name.setText(taskName)
        date.setText(taskDate)
        time.setText(taskTime)
        description.setText(taskDescription)
        priority.isChecked = taskPriority

        subject.setSelection(subjects.indexOf(taskSubject))

        val buttonConfirm = findViewById<Button>(R.id.buttonConfirm)
        buttonConfirm.setOnClickListener {
            finish()
        }
    }
}