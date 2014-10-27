package models;

import java.util.Date;
import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by jmarquez on 10/20/2014.
 */
public class  AccountModel {
    private int _accountId;
    private int _userId;
    private Date _createDate;
    private int _subscriptionId;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String DOB;
    private String Gender;
    private int price;
    private int itemID;



    //@precondition: the method has been called
    //@postcondition: returns user account’s history
    public String getHistory() {
        return null;            //not enough info

    }



    //@precondition: this method has been called
    //@postcondition: the user’s own account info is edited
    public void EditfirstName(UserModel user) {
       //user.setFirstName();            //need additional information on textfield

    }

    public void EditLastName(UserModel user) {
        //user.setLastName();            //need additional information on textfield

    }

    public void EditAddress(UserModel user) {
        //user.setAddress();            //need additional information on textfield

    }


    public void EditPhoneNumber(UserModel user) {
        //user.setPhoneNumber();            //need additional information on textfield

    }

    public void EditDOB(UserModel user) {
        //user.setDOB();            //need additional information on textfield

    }

    public void EditGender(UserModel user) {
        //user.setGender();            //need additional information on textfield

    }


    //@precondition: the method has been called
    //@postcondition: the order is cancelled
    public void cancelOrder() {
        return;             //not enough info

    }


    //@precondition: 1) this method has been called
    //2) has to be an admin
    //@postcondition: returns other user’s account info for admin
    public String getOtherFirstName(UserModel user) {
        if (user.getUserType()) {
            return user.getFirstName();
        } else {
            return null;
        }
    }

    public String getOtherLastName(UserModel user) {
        if (user.getUserType()) {
            return user.getLastName();
        } else {
            return null;
        }
    }

    public String getOtherAddress(UserModel user) {
        if (user.getUserType()) {
            return user.getAddress();
        } else {
            return null;
        }
    }

    public String getOtherDOB(UserModel user) {
        if (user.getUserType()) {
            return user.getDOB();
        } else {
            return null;
        }
    }
    public String getOtherGender(UserModel user) {
        if (user.getUserType()) {
            return user.getGender();
        } else {
            return null;
        }
    }


    //@precondition: 1) this method has been called
    //2) has to be an admin
    //@postcondition: returns other user’s history
    public void getOtherHistory() {
        //not sure if we need this in here
    }


    //@precondition: 1) this method has been called
    //2) has to be an admin
    //@postcondition: the user account info has been edited
    public void setOtherFirstName(UserModel user) {
        if (user.getUserType()) {
            //user.setFirstName();          //need more info on textfield
        } else {
            //user can't set other account info
        }
    }

    public void setOtherLastName(UserModel user) {
        if (user.getUserType()) {
            //user.setLastName();          //need more info on textfield
        } else {
            //user can't set other account info
        }

    }

    public void setAddress(UserModel user) {
        if (user.getUserType()) {
            //user.setAddress();          //need more info on textfield
        } else {
            //user can't set other account info
        }
    }

    public void setPhoneNumber(UserModel user) {
        if (user.getUserType()) {
            //user.setPhoneNumber();          //need more info on textfield
        } else {
            //user can't set other account info
        }
    }

    public void setDOB(UserModel user) {
        if (user.getUserType()) {
            //user.setDOB();          //need more info on textfield
        } else {
            //user can't set other account info
        }
    }

    public void setGender(UserModel user) {
        if (user.getUserType()) {
            //user.setGender();          //need more info on textfield
        } else {
            //user can't set other account info
        }
    }


    //@precondition: 1) this method has been called
    //2) has to be an admin
    //@postcondition: The user’s account has been disabled
    public void DisableAccount() {

    }


    //@precondition: 1) this method has been called
    // 2) has to be an admin
    //@postcondition: An  item is  added to the catalog
    public void addItem() {

    }


    //@precondition: 1) this method has been called
    //2) has to be an admin
    //@postcondition: An item has been deleted from catalog
    public void deleteItem() {

    }




    //@precondition: 1) this method has been called
    //2) has to be an admin
    //@postcondition: an item has it’s price adjusted
    public void adjustPrice() {

    }
} // end of class
