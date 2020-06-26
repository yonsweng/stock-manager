package com.yeonung.stocker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editTextId;
    EditText editTextName;
    EditText editTextPrice;
    EditText editTextCount;
    MyAPI myAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myAPI = retrofit.create(MyAPI.class);

        // EditTexts
        editTextId = (EditText)findViewById(R.id.editTextId);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextCount = (EditText)findViewById(R.id.editTextCount);

        // Set the click listener for the item search button
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(((EditText)findViewById(R.id.editTextSearch)).getText().toString());
                Log.d("button", Integer.toString(id));

                Call<Item> itemCall = myAPI.get(id);
                itemCall.enqueue(new Callback<Item>() {
                    @Override
                    public void onResponse(Call<Item> call, Response<Item> response) {
                        Log.e("get", "onResponse");
                        if(response.isSuccessful()) {
                            Log.e("get", "successful");
                            Item item = response.body();
                            editTextId.setText(Integer.toString(item.getId()));
                            editTextName.setText(item.getName());
                            editTextPrice.setText(Integer.toString(item.getPrice()));
                            editTextCount.setText(Integer.toString(item.getCount()));
                        } else {
                            Log.e("get", "unsuccessful");
                        }
                    }

                    @Override
                    public void onFailure(Call<Item> call, Throwable t) {
                        Log.e("get", "onFailure");
                    }
                });
            }
        });
    }
}