package com.example.assignmenttracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AssignmentAdapter(private val assignments: MutableList<Assignment>)
    : RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder>() {

    inner class AssignmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tvTitle)
        val course: TextView = view.findViewById(R.id.tvCourse)
        val dueDate: TextView = view.findViewById(R.id.tvDueDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssignmentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_assignment, parent, false)
        return AssignmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        val assignment = assignments[position]
        holder.title.text = assignment.title
        holder.course.text = assignment.course
        holder.dueDate.text = assignment.dueDate
    }

    override fun getItemCount() = assignments.size

    fun addSampleAssignment() {
        assignments.add(
            Assignment(
                "New Assignment",
                "Mobile Development",
                "Due: Tomorrow"
            )
        )
        notifyItemInserted(assignments.size - 1)
    }
}
