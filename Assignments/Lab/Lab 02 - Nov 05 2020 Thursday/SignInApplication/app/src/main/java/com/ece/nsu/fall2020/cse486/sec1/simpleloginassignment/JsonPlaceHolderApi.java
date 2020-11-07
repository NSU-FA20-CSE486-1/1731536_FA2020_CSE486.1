/*
 * Created by Rifat Islam on 07/11/2020.
 */
package com.ece.nsu.fall2020.cse486.sec1.simpleloginassignment;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("/signin.php")
    Call<List<User>> getUserId(@Query("username") String username,@Query("password") String password);
}
