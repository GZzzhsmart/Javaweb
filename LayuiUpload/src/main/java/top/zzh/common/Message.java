package top.zzh.common;

/**
 * Created by 消息类 on 2017/9/8.
 */
public class Message {

    public static  final  String SUCCESS = "success";

    public static  final  String FAIL = "fail";

    private String result;

    private String message;

    public Message(){}

    public Message (String result ,String message){
        this.result=result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Message success(String message){

        return new Message(SUCCESS,message);
    }

    public static  Message fail(String message){

        return new Message(SUCCESS,message);
    }
}
