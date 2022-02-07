import DataTables.SecurityQuestionsTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {

    private int intUserID = -1;
    private String strFirstName = "";
    private String strLastName = "";
    private String strUsername = "";
    private boolean bIsAdministrator = false;
    private boolean bIsLoggedIn = false;
    private boolean bUserExists = false; // indicates whether a user record exists in the database yet

    public int getIntUserID() {
        return intUserID;
    }

    public String getStrFirstName() {
        return strFirstName;
    }

    public String getStrLastName() {
        return strLastName;
    }

    public String getStrUsername() {
        return strUsername;
    }

    public boolean IsAdministrator() {
        return bIsAdministrator;
    }

    public boolean IsLoggedIn() {
        return bIsLoggedIn;
    }

    public void setStrFirstName(String strFirstName) {
        this.strFirstName = strFirstName;
    }

    public void setStrLastName(String strLastName) {
        this.strLastName = strLastName;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername;
    }

    public void setbIsAdministrator(boolean bIsAdministrator) {
        this.bIsAdministrator = bIsAdministrator;
    }

    public void setbIsLoggedIn(boolean bIsLoggedIn) {
        this.bIsLoggedIn = bIsLoggedIn;
    }

    public User(){
        bUserExists = false;
    }

    /**
     *
     * @param intUserID
     * instantiates the user with 'intUserID' from the database
     */
    public User(int intUserID) {
        DatabaseConnection connection = new DatabaseConnection();
        ResultSet set = connection.getUser(intUserID);

        try {
            if(set.first()) { // no record exists
                bUserExists = false;
            } else {
                bUserExists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param strUsername
     * @param strPassword
     * @return true if username and password are correct, this will also initialize this user instance with the user data;
     *          false if credentials are not matching
     */
    public boolean login(String strUsername, String strPassword) {
        // log in code here
        bIsLoggedIn = true;
        return false;
    }

    public boolean isLoggedIn(){
        return bIsLoggedIn;
    }

    public boolean saveUser(){
        if(bUserExists) {
            //UPDATE
        } else {
            //INSERT
            bUserExists = true;
        }
        return true;
    }

    /**
     * Inserts the given security question and answer for this user
     * @param strQuestion
     * @param strAnswer
     * @return
     */
    public boolean insertQuestionAndAnswer(String strQuestion, String strAnswer){
        SecurityQuestion question = new SecurityQuestion(strQuestion, strAnswer);
        return question.insertSecurityQuestion(this.intUserID);
    }

    /**
     *
     * @return the set of security questions from the database if they exist; otherwise, return null
     */
    public ArrayList<SecurityQuestion> getSecurityQuestions(){
        DatabaseConnection connection = new DatabaseConnection();
        ResultSet questionsSet = connection.getUserQuestions(this.intUserID);

        try {
            ArrayList<SecurityQuestion> returnList = new ArrayList<SecurityQuestion>();
            while(questionsSet.next()) {
                returnList.add(new SecurityQuestion(
                        questionsSet.getString(SecurityQuestionsTable.CN_QUESTION),
                        questionsSet.getString(SecurityQuestionsTable.CN_ANSWER),
                        questionsSet.getInt(SecurityQuestionsTable.CN_USER_ID),
                        questionsSet.getInt(SecurityQuestionsTable.CN_QUESTION_ID)
                ));
            }

            if(returnList.isEmpty()) return null;
            return returnList;
        } catch (SQLException e) {
            return null;
        }
    }



}
