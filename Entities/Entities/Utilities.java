import DataTables.SecurityQuestionBankTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Random utilities class
 */
public class Utilities {
    public Utilities(){
    }

    /**
     *
     * @return all available security question options; if none exist, or error, return null
     */
    public ArrayList<String> getAllQuestions(){
        DatabaseConnection connection = new DatabaseConnection();

        ResultSet questionsSet = connection.getAllQuestionsFromBank();
        ArrayList<String> returnList = new ArrayList<String>();

        try {
            while(questionsSet.next()){
                returnList.add(questionsSet.getString(SecurityQuestionBankTable.CN_QUESTION));
            }
            if(returnList.isEmpty()) return null;
            return returnList;
        } catch (SQLException exception){
            exception.printStackTrace();
            return null;
        }

    }
}
