package ve.com.vr.rcvmovilc.interfaces;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import ve.com.vr.rcvmovilc.model.*;

public interface RetrofitInterface {

    @POST("/login.php")
    Call<ResponseBody> getStringScalar(@Body LoginData body);
    //Call<LoginResult> getStringScalar(@Body LoginData body);

    @POST("/login.php")
    Call<LoginResult> mfLogin(@Body LoginData body);

    @FormUrlEncoded
    @POST("/login.php")
    Call<ResponseBody> post(@FieldMap Map<String,String> map);
    //Call<LoginResult> getStringScalar(@Body LoginData body);

    @FormUrlEncoded
    @POST("/login.php")
    Call<ResponseBody> post2( @Field("email") String email,   @Field("password") String password);

    @Headers({
            "Content-Type: application/json"
    })
    @FormUrlEncoded
    @POST("/login.php")
    Call<ResponseBody> post3(@Field("text") String text);


}