package models;

import java.util.Date;

/**
 * Created by Kelly An on 11/05/2014
 */
public class ReportModel {

    private int _reportId;
    private int _reportName;
    private int _userId;
    private Date _createDate;
    private int _subscriptionId;
    private UserModel _userModel;


    public ReportModel()
    {

    }

    public void setUserModel(UserModel userModel)
    {
        this._userModel = userModel;
    }

    /**
     * Get reporting id
     * @return
     */
    public String getReportId(){
        return this._reportId;
    }

    /**
     * Get reporting name
     * @return
     */
    public String getReportName(){
        return this._reportName;
    }


}