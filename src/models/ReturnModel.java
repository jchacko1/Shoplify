package models;



/**
 * Created by KellyAnn on 11/9/14.
 */
public class ReturnModel {

    private int _accountId;
    private UserModel _userModel;
    private String username;
    private String password;

    public ReturnModel(){

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
