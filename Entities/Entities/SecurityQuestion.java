import java.sql.SQLException;

public class SecurityQuestion {
    private int intUserId = -1; // the userID to whom the question belongs
    private String strQuestion = "";
    private String strAnswer = "";
    private int intQuestionId = -1;

    public SecurityQuestion(String strQuestion, String strAnswer){
        this.strQuestion = strQuestion;
        this.strAnswer = strAnswer;
    }

    public SecurityQuestion(String strQuestion, String strAnswer, int intUserId, int intQuestionId){
        this.strQuestion = strQuestion;
        this.strAnswer = strAnswer;
        this.intUserId = intUserId;
        this.intQuestionId = intQuestionId;
    }

    /**
     *
     * @param intUserId
     * @return success or failure to insert; may return false if the passed userID does not exist
     */
    public boolean insertSecurityQuestion(int intUserId){
        this.intUserId = intUserId;
        DatabaseConnection connect = new DatabaseConnection();
        if (connect.insertQuestion(intUserId, strQuestion, strAnswer)) return true;
        return false;
    }
}
