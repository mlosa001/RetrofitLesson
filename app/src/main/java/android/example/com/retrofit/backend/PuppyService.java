package android.example.com.retrofit.backend;

import android.example.com.retrofit.Model.RandoPuppy;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PuppyService {
    @GET("api/breeds/image/random")
    Call<RandoPuppy> getPuppy();
}

//calls the getPupp( method which makes http requto JSON