package models;

/**
 * Created by jmarquez on 11/2/2014.
 */
public class Enums {
    public enum UserType {
        GUEST,             //UserTypeId 1
        REGISTERED,        //UserTypeId 2
        SUBSCRIPTION,      //UserTypeId 3
        ADMIN              //UserTypeId 4
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
        Meat,                      //CategoryId 1
        Dairy,                     //CategoryId 2
        Fruit,                     //CategoryId 3
        Vegetables,                //CategoryId 4
        Drink,                     //CategoryId 5
        Dessert,                   //CategoryId 6
        Bread                      //CategoryId 7
    }



}
