package models;

/**
 * Created by jmarquez on 11/9/2014.
 */
public class SecurityQuestionsModel {
    private static final String QUESTION_1 = "What is your pet's name";
    private static final String QUESTION_2 = "What is the name of your High School?";
    private static final String QUESTION_3 = "What is your best friend's name?";

    public String[] getSecurityQuestions()
    {
      return new String[]{QUESTION_1,QUESTION_2,QUESTION_3};
    }

    public int getSecurityId(String securityQuestion)
    {
            if(securityQuestion.equalsIgnoreCase(QUESTION_1))
            {
                return 1;
            }else if(securityQuestion.equalsIgnoreCase(QUESTION_2))
            {
                return 2;
            }
            else if(securityQuestion.equalsIgnoreCase(QUESTION_3))
            {
                 return 3;
            }
            else{
                return 0;
            }
    }

}
