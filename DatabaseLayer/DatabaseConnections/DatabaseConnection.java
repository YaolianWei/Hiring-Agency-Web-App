import DataTables.SecurityQuestionsTable;

import java.sql.*;


public class DatabaseConnection {

    private Connection connection = null;
    private String url = "jdbc:sqlite:Agency.db";

    public DatabaseConnection(){
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(url);
    }

    private void disconnect() throws SQLException {
        connection.close();
    }

    public boolean isConnected(){
        if(connection == null) return false;
        else {
            try {
                return !connection.isClosed();
            } catch (SQLException e) {
                return false;
            }
        }
    }

    private Connection getConnection(){
        return connection;
    }

    /**
     * Inserts a SecurityQuestion row with userID, question, and answer
     * @param intUserId
     * @param strQuestion
     * @param strAnswer
     * @return false if insert unsuccessful; true otherwise
     */
    public boolean insertQuestion(int intUserId, String strQuestion, String strAnswer) {
        String insertIntoQuestion = "INSERT INTO " + SecurityQuestionsTable.T_NAME +
                "(" + SecurityQuestionsTable.CN_USER_ID + ", " +
                SecurityQuestionsTable.CN_QUESTION + ", " +
                SecurityQuestionsTable.CN_ANSWER + ") " +
                "VALUES ( " +
                intUserId + ", '" +
                strQuestion + "', '"
                + strAnswer + "' )";

        int rowsAffected = 0;
        try {
            PreparedStatement insertStmt = connection.prepareStatement(insertIntoQuestion);
            rowsAffected = insertStmt.executeUpdate();
        } catch (SQLException e )  {
            return false;
        }

        if(rowsAffected == 0) return false;
        try {
            disconnect();
        } catch (SQLException e) {
            return true;
        }
        return true;
    }

    public ResultSet getQuestions(int intUserId){
        String getQuestionsSQL = "SELECT " + SecurityQuestionsTable.CN_QUESTION_ID + ", " +
                SecurityQuestionsTable.CN_QUESTION + ", " +
                SecurityQuestionsTable.CN_ANSWER + "," +
                SecurityQuestionsTable.CN_USER_ID +
                " FROM " +
                SecurityQuestionsTable.T_NAME +
                " WHERE " +
                SecurityQuestionsTable.CN_USER_ID + " = " + intUserId;

        try {
            PreparedStatement statement = connection.prepareStatement(getQuestionsSQL);
            ResultSet set = statement.executeQuery();
            disconnect();
            return set;
        } catch (SQLException e) {
            try {
                disconnect();
            } catch (SQLException ex) {
                return null;
            }
            return null;
        }
    }

    /**
     * Common query function... all purpose, returns the result set from the given SELECT query
     * @param query
     * @return
     * @throws SQLException
     */
    public ResultSet runQuery(String query) throws SQLException {
        // Create a statement preparing for an SQL query
        PreparedStatement stmt = connection.prepareStatement(query);
        // Execute the prepared statement
        ResultSet results = stmt.executeQuery();

        disconnect();
        return results;
    }

    public ResultSet getUser(int intUserID) {
        return null;
    }
}
