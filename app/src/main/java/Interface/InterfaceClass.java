package Interface;

import modelClass.LogInModel;
import modelClass.LogInResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InterfaceClass {
    @POST("meal/api/users/post")
    Call<LogInResponse> logInUser(@Body LogInModel logInModel);
}
