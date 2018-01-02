package com.josepbernad.todolist.Cells;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.josepbernad.todolist.Models.TaskModel;
import com.josepbernad.todolist.R;

import java.util.List;

/**
 * Created by Josep Bernad on 30/12/2017.
 * BCN - Mallorca
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.TaskViewHolder> {

    List<TaskModel> tasks;

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView taskName;
        TextView taskDate;
        TextView taskIndex;
        CheckBox checkBox;

        TaskViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            taskName = itemView.findViewById(R.id.name_text_view);
            taskDate = itemView.findViewById(R.id.date_text_view);
            taskIndex = itemView.findViewById(R.id.index_text_view);
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }

    RVAdapter(List<TaskModel> tasks){
        this.tasks = tasks;
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.task_card, viewGroup, false);
        TaskViewHolder pvh = new TaskViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder personViewHolder, int i) {
        personViewHolder.taskName.setText(tasks.get(i).getName());
        //personViewHolder.taskDate.setText(tasks.get(i).getCreationDate());
        personViewHolder.checkBox.setActivated(tasks.get(i).isDone());
    }
}
