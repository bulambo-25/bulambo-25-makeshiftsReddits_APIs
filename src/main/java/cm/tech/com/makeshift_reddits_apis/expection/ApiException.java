package cm.tech.com.makeshift_reddits_apis.expection;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
