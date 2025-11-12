package com.example.assignmenttracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AssignmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference to RecyclerView and FAB
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val fab = findViewById<FloatingActionButton>(R.id.fab)

        // Sample assignment list
        val assignments = mutableListOf(
            Assignment("Mobile App UI", "Mobile Development", "Due: Nov 8"),
            Assignment("Database Report", "Database Systems", "Due: Nov 10"),
            Assignment("German Essay", "German 3", "Due: Nov 12")
        )

        // Connect adapter
        adapter = AssignmentAdapter(assignments)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Add new sample assignment when the "+" FAB is clicked
        fab.setOnClickListener {
            adapter.addSampleAssignment()
        }
    }
}
