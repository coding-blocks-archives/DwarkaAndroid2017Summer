package com.example.karanbalani.pokemoninformationhwl11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailPokemonActivity extends AppCompatActivity {

    String TAG = "Loging";
    ArrayList<String> imageUrls = new ArrayList<>();

    PokemonResult pokemonResult;
    TextView pokemonNameTextView, pokemonIdTextView, pokemonOrderTextView,
            pokemonWeightTextView, pokemonHeightTextView, pokemonAbilitiesTextView,
            pokemonStatsTextView, pokemonHeldItemsTextView, pokemonTypesTextView, pokemonBaseExpTextView;

    CircleImageView pokemonImage;
//    CircleImageView backFemale, backShinyFemale, backDefault, frontFemale,
//            frontShinyFemale, backShiny, frontDefault, frontShiny;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        pokemonResult = (PokemonResult) getIntent().getSerializableExtra("POKEMON");

        pokemonNameTextView = (TextView) findViewById(R.id.pokemonNameDetailTextViewId);
        pokemonIdTextView = (TextView) findViewById(R.id.pokemonDetailIdTextViewId);
        pokemonOrderTextView = (TextView) findViewById(R.id.pokemonDetailOrderTextViewId);
        pokemonWeightTextView = (TextView) findViewById(R.id.pokemonWeightIdTextViewId);
        pokemonHeightTextView = (TextView) findViewById(R.id.pokemonHeightIdTextViewId);
        pokemonAbilitiesTextView = (TextView) findViewById(R.id.pokemonAbilitiesTextViewId);
        pokemonStatsTextView = (TextView) findViewById(R.id.pokemonStatsTextViewId);
        pokemonHeldItemsTextView = (TextView) findViewById(R.id.pokemonHeldItemsTextViewId);
        pokemonTypesTextView = (TextView) findViewById(R.id.pokemonTypesTextViewId);
        pokemonBaseExpTextView = (TextView) findViewById(R.id.pokemonBaseExpIdTextViewId);
        pokemonImage = (CircleImageView) findViewById(R.id.pokemomDetailImageViewId);

//        backFemale = (CircleImageView) findViewById(R.id.backFemaleImageId);
//        backShinyFemale = (CircleImageView) findViewById(R.id.backShinyFemaleImageId);
//        backDefault = (CircleImageView) findViewById(R.id.backDefaultImageId);
//        frontFemale = (CircleImageView) findViewById(R.id.frontFemaleImageId);
//        frontShinyFemale = (CircleImageView) findViewById(R.id.frontShinyFemaleImageId);
//        backShiny = (CircleImageView) findViewById(R.id.backShinyImageId);
//        frontDefault = (CircleImageView) findViewById(R.id.frontDefaultImageId);
//        frontShiny = (CircleImageView) findViewById(R.id.frontShinyImageId);

        pokemonNameTextView.setText(pokemonResult.getName());

        if (pokemonResult.getAbilities().size() > 0) {
            String finalAbilities = "";
            StringBuilder stringBuilderAbilities = new StringBuilder();
            stringBuilderAbilities.append(pokemonResult.getAbilities().get(0).getAbility().getName() + " : " +
                    pokemonResult.getAbilities().get(0).getSlot());
            for (i = 1; i < pokemonResult.abilities.size(); i++) {
                stringBuilderAbilities.append("\n" + pokemonResult.getAbilities().get(i).getAbility().getName() + " : " +
                        pokemonResult.getAbilities().get(i).getSlot());
            }
            finalAbilities = stringBuilderAbilities.toString();
            pokemonAbilitiesTextView.setText(finalAbilities);
        } else {
            pokemonAbilitiesTextView.setText("NULL");
        }

        if (pokemonResult.getStats().size() > 0) {
            String finalStats = "";
            StringBuilder stringBuilderStats = new StringBuilder();
            stringBuilderStats.append(pokemonResult.getStats().get(0).getStat().getName() + " : " +
                    pokemonResult.getStats().get(0).getEffort() + " : " + pokemonResult.getStats().get(0).getBase_stat());
            for (i = 1; i < pokemonResult.stats.size(); i++) {
                stringBuilderStats.append("\n" + pokemonResult.getStats().get(i).getStat().getName() + " : " +
                        pokemonResult.getStats().get(i).getEffort() + " : " + pokemonResult.getStats().get(i).getBase_stat());
            }
            finalStats = stringBuilderStats.toString();
            pokemonStatsTextView.setText(finalStats);
        } else {
            pokemonStatsTextView.setText("NULL");
        }


        if (pokemonResult.getHeld_items().size() > 0) {
            String finalHeldItems = "";
            StringBuilder stringBuilderHeldItems = new StringBuilder();
            stringBuilderHeldItems.append(pokemonResult.getHeld_items().get(0).getItem().getName());
            for (i = 1; i < pokemonResult.held_items.size(); i++) {
                stringBuilderHeldItems.append(", " + pokemonResult.getHeld_items().get(i).getItem().getName());
            }
            finalHeldItems = stringBuilderHeldItems.toString();
            pokemonHeldItemsTextView.setText(finalHeldItems);
        } else {
            pokemonHeldItemsTextView.setText("NULL");
        }

        if (pokemonResult.getTypes().size() > 0) {
            String finalTypes = "";
            StringBuilder stringBuiderTypes = new StringBuilder();
            stringBuiderTypes.append(pokemonResult.getTypes().get(0).getType().getName() + " : " +
                    pokemonResult.getTypes().get(0).getSlot());
            for (i = 0; i < pokemonResult.getTypes().size(); i++) {
                stringBuiderTypes.append("\n" + pokemonResult.getTypes().get(i).getType().getName() + " : " +
                        pokemonResult.getTypes().get(i).getSlot());
            }
            finalTypes = stringBuiderTypes.toString();
            pokemonTypesTextView.setText(finalTypes);
        } else {
            pokemonTypesTextView.setText("NULL");
        }

        pokemonIdTextView.setText("" + pokemonResult.getId());
        pokemonOrderTextView.setText("" + pokemonResult.getOrder());
        pokemonWeightTextView.setText("" + pokemonResult.getWeight());
        pokemonHeightTextView.setText("" + pokemonResult.getHeight());
        pokemonBaseExpTextView.setText("" + pokemonResult.getBase_experience());

        Picasso.with(this).load(pokemonResult.getSprites().getFront_default())
                .into(pokemonImage);

//        if(pokemonResult.getSprites().getBack_female() != null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getBack_female())
//                    .into(backFemale);
//        }
//        if (pokemonResult.getSprites().getBack_shiny_female() != null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getBack_shiny_female())
//                    .into(backShinyFemale);
//        }
//        if(pokemonResult.getSprites().getBack_default() != null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getBack_default())
//                    .into(backDefault);
//        }
//        if(pokemonResult.getSprites().front_female != null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getFront_female())
//                    .into(frontFemale);
//        }
//        if(pokemonResult.getSprites().getFront_shiny_female() != null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getFront_shiny_female())
//                    .into(frontShinyFemale);
//        }
//        if(pokemonResult.getSprites().getBack_shiny() != null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getBack_shiny())
//                    .into(backShiny);
//        }
//        if(pokemonResult.getSprites().getFront_default() !=null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getFront_default())
//                    .into(frontDefault);
//        }
//        if(pokemonResult.getSprites().getFront_shiny() != null){
//            Picasso.with(getBaseContext()).load(pokemonResult.getSprites().getFront_shiny())
//                    .into(frontShiny);
//        }


    }

}
