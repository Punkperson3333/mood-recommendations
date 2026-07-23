import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String url =
                "jdbc:mysql://localhost:3306/mood_recommendations";

        String username = "root";

        String password = "Rajesh2709$";


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter mood: ");
        String selectedMood=scanner.nextLine();
        System.out.print("Enter type (Movie, Book, or Both):");
        String selectedType=scanner.nextLine();

        try {

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );


            String query;

            if (selectedType.equals("Both")) {

                query =
                        "SELECT * FROM recommendations "
                        + "WHERE mood = '" + selectedMood + "'";

            } else {

                query =
                        "SELECT * FROM recommendations "
                        + "WHERE mood = '" + selectedMood + "' "
                        + "AND type = '" + selectedType + "'";

            }


            Statement statement =
                    connection.createStatement();


            ResultSet result =
                    statement.executeQuery(query);


            while (result.next()) {

                String title =
                        result.getString("title");

                String type =
                        result.getString("type");

                String mood =
                        result.getString("mood");

                String genre =
                        result.getString("genre");

                double rating =
                        result.getDouble("rating");


                System.out.println(
                        title
                        + " | "
                        + type
                        + " | "
                        + mood
                        + " | "
                        + genre
                        + " | Rating: "
                        + rating
                );

            }


            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}