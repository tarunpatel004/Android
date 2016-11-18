package demo.com.testapplication.rest;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiInterface {

    @POST("userActivity.json")
    Call<ResponseBody> postUserActivity(@Body HashMap<String, String> body);

    @POST("userLastWeekData.json")
    Call<ResponseBody> getUserWeeklyActivity(@Body HashMap<String, String> body);

}
