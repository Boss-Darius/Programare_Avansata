package printsqlexception;

import java.sql.SQLException;

public class PrintSqlException {
    public static void print(SQLException ex) {
        for (Throwable e : ex) { //SQLException implements Iterable<Throwable>
            //chained exceptions
            if (e instanceof SQLException sqlEx) {
                System.err.println("SQLState : " + sqlEx.getSQLState());
                System.err.println("Error Code: " + sqlEx.getErrorCode());
                System.err.println("Message : " + sqlEx.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
