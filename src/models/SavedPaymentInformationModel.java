package models;

/**
 * Created by jmarquez on 11/29/2014.
 */
public class SavedPaymentInformationModel {

    String _creditCardType;
    String _cardHoldersName;
    String _creditCardNumber;
    String _expirationDate;
    String _cvs;

    public SavedPaymentInformationModel(String creditCardType, String cardHoldersName, String creditCardNumber, String expirationDate, String cvs)
    {
        _creditCardType = creditCardType;
        _cardHoldersName = cardHoldersName;
        _creditCardNumber = creditCardNumber;
        _expirationDate = expirationDate;
        _cvs = cvs;
    }

    public void setCreditCardType(String creditCardType)
    {
        _creditCardType = creditCardType;
    }

    public void setCardHoldersName(String cardHoldersName)
    {
        _cardHoldersName = cardHoldersName;
    }

    public void setCreditCardNumber(String creditCardNumber)
    {
        _creditCardNumber = creditCardNumber;
    }

    public void setExpirationDate(String expirationDate)
    {
        _expirationDate = expirationDate;
    }

    public void setCvs(String cvs)
    {
        _cvs = cvs;
    }

    public String getCreditCardType()
    {
        return _creditCardType;
    }

    public String getCardHoldersName()
    {
        return _cardHoldersName;
    }

    public String getCreditCardNumber()
    {
        return _creditCardNumber;
    }

    public String getExpirationDate()
    {
        return _expirationDate;
    }

    public String getCvs()
    {
        return _cvs;
    }

}
