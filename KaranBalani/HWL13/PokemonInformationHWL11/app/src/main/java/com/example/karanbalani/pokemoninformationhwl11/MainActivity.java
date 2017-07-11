package com.example.karanbalani.pokemoninformationhwl11;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    PokemonResult pokemonResult;

    String BASE_URL = "http://pokeapi.co/api/v2/pokemon/";
    String TAG = "Logging";

    static Integer explicitPokemonId = 1;

    ImageView pokemonImageView;
    TextView pokemonNameTextView, pokemonRankTextView;
    Button nextPokemonButton;
    Button previousPokemonButton;
    ImageButton searchPokemonButton;
    CardView cardView;

    ProgressDialog progressDialog;

    SharedPreferences sharedPreferences; //getSharedPreferences for custom file name

    SharedPreferences.Editor editor;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("Saved", pokemonResult);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getPreferences(MODE_PRIVATE);
        editor = sharedPreferences.edit();

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        pokemonImageView = (ImageView) findViewById(R.id.pokemonImageViewId);
        pokemonNameTextView = (TextView) findViewById(R.id.pokemonNameTextViewId);
        pokemonRankTextView = (TextView) findViewById(R.id.pokemonRankTextViewId);
        nextPokemonButton = (Button) findViewById(R.id.nextPokemonImageButtonId);
        previousPokemonButton = (Button) findViewById(R.id.previousPokemonImageButtonId);
        searchPokemonButton = (ImageButton) findViewById(R.id.searchPokemonImageButtonId);
        cardView = (CardView) findViewById(R.id.cardViewPokemonId);

        if (savedInstanceState != null && savedInstanceState.containsKey("Saved")) {
            pokemonResult = (PokemonResult) savedInstanceState.getSerializable("Saved");
            Log.e(TAG, "onCreate: onsaved called ");
            if (pokemonResult.getDetail() == null) {

                cardView.setVisibility(View.VISIBLE);
                if (explicitPokemonId == 1) {
                    previousPokemonButton.setVisibility(View.INVISIBLE);
                } else {
                    previousPokemonButton.setVisibility(View.VISIBLE);
                }

                if (explicitPokemonId == 721) {
                    nextPokemonButton.setVisibility(View.INVISIBLE);
                } else {
                    nextPokemonButton.setVisibility(View.VISIBLE);
                }
                pokemonNameTextView.setText(pokemonResult.getName());
                pokemonRankTextView.setText("" + pokemonResult.getOrder());
                Picasso.with(getBaseContext())
                        .load(pokemonResult.getSprites().getFront_default())
                        .into(pokemonImageView);
            }
        } else {
            progressDialog.show();
            NetworkingAndParsing(explicitPokemonId);
//            explicitPokemonId = sharedPreferences.getInt("explicitPokemonId", 1);
//            cardView.setVisibility(View.VISIBLE);
//            pokemonNameTextView.setText(sharedPreferences.getString("nameOfPokemon", "null"));
//            pokemonRankTextView.setText("" + sharedPreferences.getInt("orderOfPokemon", 1));
//            Picasso.with(MainActivity.this).load(sharedPreferences.getString("imageUrl", null)).into(pokemonImageView);
//            NetworkingAndParsing(sharedPreferences.getInt("explicitPokemonId", 1));
        }


        nextPokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (explicitPokemonId <= 721) {
                    progressDialog.show();
                    NetworkingAndParsing(++explicitPokemonId);
                } else {
                    Toast.makeText(getBaseContext(), "No Content Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        previousPokemonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (explicitPokemonId > 1) {
                    progressDialog.show();
                    NetworkingAndParsing(--explicitPokemonId);
                } else {
                    Toast.makeText(getBaseContext(), "No Content Available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        searchPokemonButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View view) {

                AlertDialog.Builder promtPokemonId = new AlertDialog.Builder(MainActivity.this);

                promtPokemonId.setTitle("Enter Pokemon ID");

                final EditText enteredIdEditText = new EditText(MainActivity.this);


                enteredIdEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                enteredIdEditText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                promtPokemonId.setView(enteredIdEditText);


                promtPokemonId.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (TextUtils.isEmpty(enteredIdEditText.getText())) {
                            Toast.makeText(MainActivity.this, "NO ID ENTERED", Toast.LENGTH_SHORT).show();
                        } else if (Integer.parseInt(enteredIdEditText.getText().toString()) > 0 &&
                                Integer.parseInt(enteredIdEditText.getText().toString()) <= 721) {
                            explicitPokemonId = Integer.parseInt(enteredIdEditText.getText().toString());
                            progressDialog.show();
                            NetworkingAndParsing(explicitPokemonId);
                        } else {
                            Toast.makeText(MainActivity.this, "ID MUST BE BETWEEN\n1 to 721", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                promtPokemonId.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                promtPokemonId.create().show();
            }
        });


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pokemonResult.getDetail() == null) {
                    Intent detailActivity = new Intent(MainActivity.this, DetailPokemonActivity.class);
                    detailActivity.putExtra("POKEMON", pokemonResult);
                    startActivity(detailActivity);
                }
            }
        });
    }

//    @Override
//    protected void onPause() {
//
//        editor.putString("nameOfPokemon", pokemonResult.getName());
//        editor.putInt("orderOfPokemon", pokemonResult.getOrder());
//        editor.putInt("expilicitPokemonId" , explicitPokemonId);
//        editor.putString("imageUrl", pokemonResult.getSprites().getFront_default());
//        editor.commit();
//        super.onPause();
//    }

    public void NetworkingAndParsing(final Integer explicitPokemonId) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(BASE_URL + explicitPokemonId + "/")
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: " + e.getLocalizedMessage());
                Log.e(TAG, "onFailure: " + call.request().url());
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();
                        Toast.makeText(getBaseContext(), "Connection TimeOut\nTry Again", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String pokemonResponse = response.body().string();

                Gson gson = new Gson();


                pokemonResult = gson.fromJson(pokemonResponse, PokemonResult.class);

                Log.e(TAG, "onResponse: " + pokemonResponse);
                Log.e(TAG, "onResponse: " + pokemonResult.getDetail());
                Log.e(TAG, "onResponse: " + explicitPokemonId);


                if (pokemonResult.getDetail() == null) {
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cardView.setVisibility(View.VISIBLE);
                            if (explicitPokemonId == 1) {
                                previousPokemonButton.setVisibility(View.INVISIBLE);
                            } else {
                                previousPokemonButton.setVisibility(View.VISIBLE);
                            }

                            if (explicitPokemonId == 721) {
                                nextPokemonButton.setVisibility(View.INVISIBLE);
                            } else {
                                nextPokemonButton.setVisibility(View.VISIBLE);
                            }
                            pokemonNameTextView.setText(pokemonResult.getName());
                            pokemonRankTextView.setText("" + pokemonResult.getOrder());
                            Picasso.with(getBaseContext())
                                    .load(pokemonResult.getSprites().getFront_default())
                                    .networkPolicy(NetworkPolicy.OFFLINE)
                                    .into(pokemonImageView, new com.squareup.picasso.Callback() {
                                        @Override
                                        public void onSuccess() {

                                        }

                                        @Override
                                        public void onError() {
                                            Picasso.with(getBaseContext())
                                                    .load(pokemonResult.getSprites().getFront_default())
                                                    .into(pokemonImageView);
                                        }
                                    });
                            progressDialog.hide();
                        }
                    });
                }
            }
        });
    }
}
