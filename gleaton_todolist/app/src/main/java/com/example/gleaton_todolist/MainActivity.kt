package com.example.gleaton_todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

/*
David Gleaton
4/6/21
This is the  main activity for the program
 */

class MainActivity : AppCompatActivity() {


    //create a lateinit object of TodoAdapter to access addTodo and deleteTodos
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set the adapter and layout manager for recycle view
        val recyclerView: RecyclerView = rvTodoItems
        recyclerView.layoutManager = LinearLayoutManager(this)
        val todos: ArrayList<Todo> = ArrayList()
        adapter = TodoAdapter(todos)
        recyclerView.adapter = adapter

        //Grab edittext and place into new todo
        btnAddTodo.setOnClickListener {
            //take the input from edittext and use addTodo
            var editTextInput = etTodoTitle.text.toString()
            var newtodo = Todo(editTextInput, false)
            adapter.addTodo(newtodo)
        }
        //Activit the deltetodos fun
        btnDeleteDoneTodos.setOnClickListener {
            //call deleteTodo method
            adapter.deleteTodos()
        }




    }
}