package android.example.com.retrofit;

import android.example.com.retrofit.Model.RandoPuppy;
import android.example.com.retrofit.backend.PuppyService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private PuppyService puppyService;
    private static final String TAG = "JSON?";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // creating the service so we can use it to make requests:
        puppyService = retrofit.create(PuppyService.class);

        Call<RandoPuppy> puppy = puppyService.getPuppy();
        puppy.enqueue(new Callback<RandoPuppy>() {
            @Override
            public void onResponse(Call<RandoPuppy> call, Response<RandoPuppy> response) {
                Log.d(TAG, "onResponse: " + response.body().getMessage());
            }

            @Override
            public void onFailure(Call<RandoPuppy> call, Throwable t) {
                Log.d(TAG, "onResponse: " + t.toString());
            }
        });
    }

    //does this go here?
    //wat is the diff w it going in a singleton
//    As you can see in Call, we are saying that whatever JSON object we get back, we are treating it like our data model "RandoPuppy" and so we'll be able to use the getter methods in RandoPuppy.java to get the URL string for photo link from the JSON key "message". But that's only if we get a response. If we get a response (onResponse()), we should be able to log our response body, and its contents. If we fail, (onFailure()), we should be able to log our error, and fail gracefully.



}
