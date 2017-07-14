package com.codingblocks.tododb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codingblocks.tododb.db.TaskDatabase;
import com.codingblocks.tododb.model.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        final EditText etTask = (EditText) findViewById(R.id.etTask);
        tasks = new ArrayList<>();

        final TaskAdapter taskAdapter = new TaskAdapter(tasks);

        RecyclerView rvTasks = (RecyclerView) findViewById(R.id.rvTasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        rvTasks.setAdapter(taskAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task newTask = new Task(etTask.getText().toString(),false);
                TaskDatabase tb = new TaskDatabase(MainActivity.this);

                tb.insertTask(newTask);
                tasks.clear();

                tasks.addAll(tb.getAllTasks());

                taskAdapter.notifyDataSetChanged();

            }
        });
    }


    public class TaskHolder extends RecyclerView.ViewHolder{
        TextView taskName, status;

        public TaskHolder(View itemView) {
            super(itemView);
            taskName = (TextView) itemView.findViewById(R.id.tvTask);
            status = (TextView) itemView.findViewById(R.id.tvStatus);
        }
    }

    public class TaskAdapter extends RecyclerView.Adapter<TaskHolder>{

        ArrayList<Task> taskArrayList;

        public TaskAdapter(ArrayList<Task> taskArrayList) {
            this.taskArrayList = taskArrayList;
        }

        @Override
        public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = getLayoutInflater().inflate(R.layout.single_task_item,
                    parent,
                    false);

            return new TaskHolder(v);
        }

        @Override
        public void onBindViewHolder(TaskHolder holder, int position) {
            Task currentTask = taskArrayList.get(position);

            holder.taskName.setText(currentTask.getTaskName());

            holder.status.setText(currentTask.isDone() ? "Complete" : "Pending");
        }

        @Override
        public int getItemCount() {
            return taskArrayList.size();
        }
    }


}
