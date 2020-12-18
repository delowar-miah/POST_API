package modelClass;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LogInResponse {
    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("UserId")
    @Expose
    private Integer userId;
    @SerializedName("Token")
    @Expose
    private String token;
    @SerializedName("ResultState")
    @Expose
    private Boolean resultState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getResultState() {
        return resultState;
    }

    public void setResultState(Boolean resultState) {
        this.resultState = resultState;
    }

}
