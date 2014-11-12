package models;


/**
 * Created by KellyAnn on 11/9/14.
 */
public class ReturnModel {

    private int _accountId;
    private UserModel _userModel;
    private String username;
    private String password;
    private String requestDateTime;
    private String responseDateTime;
    private String returnMsg;
    private String returnId;

    public ReturnModel(){

    }

    public String getRequestDateTime(){
        return requestDateTime;
    }

    public void setRequestDateTime(String value){
        this.requestDateTime = value;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(String value){
        this.responseDateTime = value;
    }

    public String getReturnId(){
        return returnId;
    }

    public void setReturnId(String value){
        this.returnId = value;
    }

    public String getReturnMsg(){
        return returnMsg;
    }

    public void setReturnMsg(String value){
        this.returnMsg = value;
    }




    //TODO:Get the return form from file?
    public void getReturnForm(){

    }

    public void cancelReturn(){
        return;
    }

    //@precondition: 1) this method has been called
    //2) has to be an admin
    //@postcondition: returns other user’s history
    public void getOtherHistory() {

    }

}
