package models;


/**
 * Created by KellyAnn on 11/9/14.
 */
public class ReturnModel {

    private int _userId;
    private int _orderId;
    private int _itemId;
    private int _returnId;
    private double _orderTotal;
    private boolean _isSubscriptionOrder;
    private UserModel _userModel;
    private String requestDateTime;
    private String responseDateTime;
    private String returnMsg;

    public ReturnModel(int returnId, int orderId, double orderTotal,int userId,boolean isSubscriptionOrder){
        this._returnId = returnId;
        this._orderId = orderId;
        this._orderTotal = orderTotal;
        this._userId = userId;
        this._isSubscriptionOrder = isSubscriptionOrder;
    }

    public int getReturnId(){
        return _returnId;
    }

    public void setReturnId(int returnId){
        this._returnId = returnId;
    }

    public int getUserId(){
        return _userId;
    }

    public void setUserId(int userId){
        this._userId = userId;
    }

    public int getOrderId(){
        return _orderId;
    }

    public void setOrderId(int orderId){
        this._orderId = orderId;
    }

    public int getItemId(){
        return _itemId;
    }

    public void setItemId(int itemId){
        this._itemId = itemId;
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


}
