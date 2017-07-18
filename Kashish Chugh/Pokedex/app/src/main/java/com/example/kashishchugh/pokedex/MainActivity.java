package com.example.kashishchugh.pokedex;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    TextView name,rank,height,weight,experience,type;
    ImageView image,next,previous,search;
    EditText editText;
    ProgressDialog progress;
    ArrayList<Pokem> pokemArrayList=new ArrayList<>();
    int id;
    String r;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onPause() {
        super.onPause();

        editor.putString("name",name.getText().toString());
        editor.putString("rank",rank.getText().toString());
        editor.putString("weight",weight.getText().toString());
        editor.putString("height",height.getText().toString());
        editor.putString("experience",experience.getText().toString());
        editor.putInt("id",id);
        editor.apply();
        Log.e("TAG", "onPause: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "onStop: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        name.setText(sharedPreferences.getString("name","name"));
        rank.setText(sharedPreferences.getString("rank","rank"));
        weight.setText(sharedPreferences.getString("weight","weight"));
        height.setText(sharedPreferences.getString("height","height"));
        experience.setText(sharedPreferences.getString("experience","experience"));
        id=sharedPreferences.getInt("id",1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.pokeName);
        rank = (TextView) findViewById(R.id.pokeRank);
        height = (TextView) findViewById(R.id.pokeHeight);
        weight = (TextView) findViewById(R.id.pokeWeight);
        experience = (TextView) findViewById(R.id.pokeExperience);
        type = (TextView) findViewById(R.id.pokeType);
        final OkHttpClient okHttpClient = new OkHttpClient();
        image = (ImageView) findViewById(R.id.pokeImage);
        next = (ImageView) findViewById(R.id.next);
        search= (ImageView) findViewById(R.id.search);
        previous= (ImageView) findViewById(R.id.previous);
        sharedPreferences=getPreferences(MODE_PRIVATE);
        editor=sharedPreferences.edit();


        LinearLayout l= (LinearLayout) getLayoutInflater().inflate(R.layout.alert_view,null);
        editText=l.findViewById(R.id.dialogueRank);
        final AlertDialog dialog=new AlertDialog.Builder(this)
                .setView(l)
                .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        r=editText.getText().toString();
                        Toast.makeText(MainActivity.this,editText.getText().toString(),Toast.LENGTH_SHORT).show();
                        progress=new ProgressDialog(MainActivity.this);
                        progress.setMessage("Loading");
                        progress.setCancelable(false);
                        progress.show();
//                id++;
//                final String s= String.valueOf(id);
                        final Request request = new Request.Builder().url("http://pokeapi.co/api/v2/pokemon/"+r+"/").build();

                        okHttpClient.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {
                                Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                                Log.e("TAG", "onFailure: " + call.request().url());
                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                String result = response.body().string();

                                Gson gson = new Gson();
                                final Poke pokemon = gson.fromJson(result, Poke.class);
                                final TypesList pokem = gson.fromJson(result, TypesList.class);
                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {


                                        name.setText(pokemon.getName());
                                        id = pokemon.getId();
                                        rank.setText(r);
                                        weight.setText("Weight: " + pokemon.getWeight() + " lbs");
                                        height.setText("Height:" + pokemon.getHeight() + " ft");
                                        experience.setText("Base Experience: " + pokemon.getExpeience() + " XP");
                                        Picasso.with(MainActivity.this).load(pokemon.getSprites().front_default).into(image);
                                        pokemArrayList.clear();
                                        pokemArrayList.addAll(pokem.getTypes());
                                        type.setText("Type: ");
                                        for (int i = 0; i < pokemArrayList.size(); i++) {
                                            Pokem pokem1=pokemArrayList.get(i);
                                            type.append(pokem1.getType().getName());
                                            if (i!=pokemArrayList.size()-1)
                                            type.append(",");
                                        }
                                        Log.e("TAG", "type: " + type);
                                        progress.hide();

                                    }
                                });
                            }
                        });
                    }
                }).create();
//        final Request request = new Request.Builder().url("http://pokeapi.co/api/v2/pokemon/1/").build();
//
//        okHttpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
//                Log.e("TAG", "onFailure: " + call.request().url());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                String result = response.body().string();
//
//                Gson gson = new Gson();
//                final Poke pokemon = gson.fromJson(result, Poke.class);
//                final TypesList pokem = gson.fromJson(result, TypesList.class);
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        name.setText(pokemon.getName());
//                        rank.setText("1");
//                        id=pokemon.getId();
//                        weight.setText("Weight: " + pokemon.getWeight() + " lbs");
//                        height.setText("Height:" + pokemon.getHeight() + " ft");
//                        experience.setText("Base Experience: " + pokemon.getExpeience() + " XP");
//                        Picasso.with(MainActivity.this).load(pokemon.getSprites().front_default).into(image);
//                        pokemArrayList.clear();
//                        pokemArrayList.addAll(pokem.getTypes());
//                        type.setText("Type: ");
//                        for (int i = 0; i < pokemArrayList.size(); i++) {
//                            Pokem pokem1=pokemArrayList.get(i);
//                            type.append(pokem1.getType().getName());
//                            if (i!=pokemArrayList.size()-1)
//                                type.append(",");
//                        }
//                        Log.e("TAG", "type: " + type);
//
//
//
//                    }
//                });
//            }
//        });


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.show();
//
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress=new ProgressDialog(MainActivity.this);
                progress.setMessage("Loading");
                progress.setCancelable(false);
                progress.show();
                id++;
                final String s= String.valueOf(id);
                final Request request = new Request.Builder().url("http://pokeapi.co/api/v2/pokemon/"+id+"/").build();

                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                        Log.e("TAG", "onFailure: " + call.request().url());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();

                        Gson gson = new Gson();
                        final Poke pokemon = gson.fromJson(result, Poke.class);
                        final TypesList pokem = gson.fromJson(result, TypesList.class);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                name.setText(pokemon.getName());
                                id = pokemon.getId();
                                rank.setText(s);
                                weight.setText("Weight: " + pokemon.getWeight() + " lbs");
                                height.setText("Height:" + pokemon.getHeight() + " ft");
                                experience.setText("Base Experience: " + pokemon.getExpeience() + " XP");
                                Picasso.with(MainActivity.this).load(pokemon.getSprites().front_default).into(image);
                                pokemArrayList.clear();
                                pokemArrayList.addAll(pokem.getTypes());
//                                type.setText("");
                                type.setText("Type: ");
                                for (int i = 0; i < pokemArrayList.size(); i++) {
                                    Pokem pokem1=pokemArrayList.get(i);
                                    type.append(pokem1.getType().getName());
                                    if (i!=pokemArrayList.size()-1)
                                        type.append(",");
                                }
                                Log.e("TAG", "run: "+pokemArrayList.size());
                                progress.hide();

                            }
                        });
                    }
                });

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id!=1){
                    progress=new ProgressDialog(MainActivity.this);
                    progress.setMessage("Loading");
                    progress.setCancelable(false);
                    progress.show();
                    id--;
                    final String s= String.valueOf(id);
                    final Request request = new Request.Builder().url("http://pokeapi.co/api/v2/pokemon/"+id+"/").build();

                    okHttpClient.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.e("TAG", "onFailure: " + e.getLocalizedMessage());
                            Log.e("TAG", "onFailure: " + call.request().url());
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String result = response.body().string();

                            Gson gson = new Gson();
                            final Poke pokemon = gson.fromJson(result, Poke.class);
                            final TypesList pokem = gson.fromJson(result, TypesList.class);
                            MainActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    name.setText(pokemon.getName());
                                    id = pokemon.getId();
                                    rank.setText(s);
                                    weight.setText("Weight: " + pokemon.getWeight() + " lbs");
                                    height.setText("Height:" + pokemon.getHeight() + " ft");
                                    experience.setText("Base Experience: " + pokemon.getExpeience() + " XP");
                                    Picasso.with(MainActivity.this).load(pokemon.getSprites().front_default).into(image);
                                    pokemArrayList.clear();
                                    pokemArrayList.addAll(pokem.getTypes());
                                    type.setText("Type: ");
                                    for (int i = 0; i < pokemArrayList.size(); i++) {
                                        Pokem pokem1=pokemArrayList.get(i);
                                        type.append(pokem1.getType().getName());
                                        if (i!=pokemArrayList.size()-1)
                                            type.append(",");
                                    }
                                    progress.hide();

                                }
                            });
                        }
                    });

                }
            }
        });
    }
}
