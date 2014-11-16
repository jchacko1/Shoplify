package models;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class Enums {
    public enum UserType {
        GUEST,             //UserTypeId 0
        REGISTERED,        //UserTypeId 1
        SUBSCRIPTION,      //UserTypeId 2
        ADMIN              //UserTypeId 3
    }

    public enum DiscountType {
        OFFORDER,
        OFFITEM,
        FREESHIPPING
    }

    //todo What could be the possible report type?
    public enum ReportType {

    }



    public enum Category {
        Meat,                      //CategoryId 0
        Dairy,                     //CategoryId 1
        Fruit,                     //CategoryId 2
        Vegetables,                //CategoryId 3
        Drink,                     //CategoryId 4
        Dessert,                   //CategoryId 5
        Bread                      //CategoryId 6
    }



}
