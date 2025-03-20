package testPack.dao;

import org.junit.Test;
import org.springframework.stereotype.Component;
import testPack.models.Worker;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;


@Component
public class WorkerDAO {
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

    public List<Worker> index() {
        List<Worker> workers = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Worker";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Worker worker = new Worker();

                worker.setId(resultSet.getInt("id"));
                worker.setName(resultSet.getString("name"));
                worker.setAge(resultSet.getInt("age"));
                worker.setEducation(resultSet.getString("education"));
                worker.setPosition(resultSet.getString("position"));

                workers.add(worker);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return workers;
    }

    @Test
    public void data_older30() {
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Worker WHERE Age > 30 AND education <> 'Vyshee'";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Worker worker = new Worker();

                worker.setId(resultSet.getInt("id"));
                worker.setName(resultSet.getString("name"));

                worker.setAge(resultSet.getInt("age"));
                worker.setEducation(resultSet.getString("education"));
                // Логіка першого тесту
                System.out.println("worker's Age is " + worker.getAge());
                assertTrue(worker.getAge() > 30);

                // Логіка другого тесту
                System.out.println("worker's Education is " + worker.getEducation());
                assertNotSame("Vyshee", worker.getEducation());

                worker.setPosition(resultSet.getString("position"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

/////////////////////////////////////////////////////////////////////////////////////////////////
    public List<Worker> older30() {
        List<Worker> workers = new ArrayList<>();

        this.data_older30();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Worker WHERE Age > 30 AND education <> 'Vyshee'";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Worker worker = new Worker();

                worker.setId(resultSet.getInt("id"));
                worker.setName(resultSet.getString("name"));

                worker.setAge(resultSet.getInt("age"));
                worker.setEducation(resultSet.getString("education"));
                worker.setPosition(resultSet.getString("position"));

                workers.add(worker);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return workers;
    }

    public Worker show(int id) {
        Worker worker = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Worker WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            worker = new Worker();

            worker.setId(resultSet.getInt("id"));
            worker.setName(resultSet.getString("name"));
            worker.setAge(resultSet.getInt("age"));
            worker.setEducation(resultSet.getString("education"));
            worker.setPosition(resultSet.getString("position"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return worker;
    }

    public void save(Worker worker) {
        try {
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("SELECT MAX(id) AS id FROM Worker");

            ResultSet resultSet = preparedStatement1.executeQuery();

            resultSet.next();
            maxID = resultSet.getInt("id");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Worker VALUES(?, ?, ?, ?, ?)");

            maxID++;
            preparedStatement.setInt(1, maxID);
            preparedStatement.setString(2, worker.getName());
            preparedStatement.setInt(3, worker.getAge());
            preparedStatement.setString(4, worker.getEducation());
            preparedStatement.setString(5, worker.getPosition());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Worker updatedWorker) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Worker SET name=?, age=?, education=?, position=? WHERE id=?");

            preparedStatement.setString(1, updatedWorker.getName());
            preparedStatement.setInt(2, updatedWorker.getAge());
            preparedStatement.setString(3, updatedWorker.getEducation());
            preparedStatement.setString(4, updatedWorker.getPosition());
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement =
                null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Worker WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
