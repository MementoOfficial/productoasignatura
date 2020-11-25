package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.memento.data.Categories;
import com.example.memento.model.Catalog;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Notes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        String json;
        Gson gson = new Gson();

        //  De Java a JSON
        List<Catalog> catalog = new ArrayList<>();
        catalog.add(new Catalog("Movies", "¿Te gustan las peliculas", R.drawable.ic_baseline_local_movies_24));
        catalog.add(new Catalog("Videogames", "¿Eres un gamer?", R.drawable.ic_baseline_videogame_asset_24));
        catalog.add(new Catalog("Series", "¿Te gustan las series?", R.drawable.ic_baseline_series_tv_24));
        catalog.add(new Catalog("Anime", "¿Eres alguien de cultura", R.drawable.ic_baseline_anchor_24));

        Categories categories = new Categories(catalog);
         json = gson.toJson(categories);

        TextView tv_json = findViewById(R.id.tv_json);

        // Textview para mostrar la lectura archivo JSON en una pantalla, puede hacer un breakpoint para observar el json
        tv_json.setText(getJsonFromAssets(this));
        Log.d("Catalog", getJsonFromAssets(this));
    }
            //Leyendo el archivo JSON
    public static String getJsonFromAssets(Context context) {

        try {
            String jsonString;
            InputStream is = context.getAssets().open("Category.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer);
            return jsonString;
        } catch (IOException e) {
            Log.e("FileHelper",
                    "Ocurrió un error al procesar el archivo. " + e.getMessage()
            );
            return null;
        }
    }
}