package com.codingblocks.tododb;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codingblocks.tododb.db.TableTask;
import com.codingblocks.tododb.db.TaskDatabase;
import com.codingblocks.tododb.model.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        final EditText etTask = (EditText) findViewById(R.id.etTask);
        tasks = new ArrayList<>();

        taskAdapter = new TaskAdapter(tasks);

        RecyclerView rvTasks = (RecyclerView) findViewById(R.id.rvTasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);




        rvTasks.setAdapter(taskAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Task newTask = new Task(etTask.getText().toString(),false);
                TaskDatabase tb = new TaskDatabase(MainActivity.this);

                tb.insertTask(newTask);
                update(tb);

                Intent i = new Intent(getBaseContext(),TaskReceiver.class);

                i.putExtra("TASK",newTask.getTaskName());

                PendingIntent pi = PendingIntent.getBroadcast(getBaseContext(),
                        1,
                        i,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + 10000,
                        pi);

            }
        });
    }

    public void update(TaskDatabase tb){
        tasks.clear();

        tasks.addAll(tb.getAllTasks());

        taskAdapter.notifyDataSetChanged();
    }


    public class TaskHolder extends RecyclerView.ViewHolder{
        TextView taskName, status;
        LinearLayout llayout;
        public TaskHolder(View itemView) {
            super(itemView);
            taskName = (TextView) itemView.findViewById(R.id.tvTask);
            status = (TextView) itemView.findViewById(R.id.tvStatus);
            llayout = (LinearLayout) itemView.findViewById(R.id.llayout);

            llayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Task currentTask = tasks.get(getAdapterPosition());
                    TaskDatabase tdb = new TaskDatabase(MainActivity.this);

                    ContentValues cv = new ContentValues();

                    cv.put(TableTask.COLUMN_IS_DONE, currentTask.isDone() ? 0 : 1);

                    tdb.updateRow(currentTask.getId(),cv);

                    update(tdb);

                }
            });


            llayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Task currentTask = tasks.get(getAdapterPosition());
                    TaskDatabase tdb = new TaskDatabase(MainActivity.this);
                    tdb.deleteTask(currentTask.getId());

                    update(tdb);
                    return true;
                }
            });

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
