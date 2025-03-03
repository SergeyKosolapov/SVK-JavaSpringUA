package taskPack.dao;

import taskPack.models.Row;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RowDAO {
    public int maxID = 0;

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "D34080cc01";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Row> index() {
        List<Row> rows = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Trow";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Row row = new Row();

                row.setId(resultSet.getInt("id"));
                row.setData1(resultSet.getString("data1"));

                rows.add(row);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows;
    }

    public Row show(int id) {
        Row row = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Trow WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            row = new Row();

            row.setId(resultSet.getInt("id"));
            row.setData1(resultSet.getString("data1"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return row;
    }


    public void save(Row row) {
        try {
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("SELECT MAX(id) AS id FROM Trow");

            ResultSet resultSet = preparedStatement1.executeQuery();

            resultSet.next();
            maxID = resultSet.getInt("id");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO TRow VALUES(?, ?)");

            maxID++;
            preparedStatement.setInt(1, maxID);
            preparedStatement.setString(2, row.getData1());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Row updatedRow) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Trow SET data1=? WHERE id=?");

            preparedStatement.setString(1, updatedRow.getData1());
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
