package com.example.gleaton_todolist


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoAdapter(private val todos: ArrayList<Todo>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
{

    //Class for TodoViewHolder
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    //pre:
    //post: Returns inflated view holders for items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            TodoViewHolder {
            //inflate the view and return the viewholder
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false) as View
            return TodoViewHolder(view)

    }

    //pre: todo item is passed in
    //post: Adds todo and notify's the recyclerview of insert
    fun addTodo(todo: Todo) {
        //implement add item
        todos.add(todo)
        notifyItemInserted(todos.size)
    }


    //pre:
    //post: Deletes all todos that have been checked
    fun deleteTodos() {
        //implement removal of item

        for(i in todos.indices.reversed()){
            if(todos[i].boolean){
                todos.removeAt(i)
            }
        }

        notifyDataSetChanged()
    }



    //pre:
    //post: sets up and modifies holder objects based on the state of the app
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply{
            //assign values to the item
            holder.itemView.textview1.text = curTodo.string
            holder.itemView.cbDone.isChecked = curTodo.boolean
        }
        holder.itemView.cbDone.setOnClickListener { todos[position].boolean = !todos[position].boolean }




    }

    //pre:
    //post: returns todos item size
    override fun getItemCount(): Int {
            // return size of list
            return todos.size;
    }
}