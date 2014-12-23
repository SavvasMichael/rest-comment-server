package org.savvas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {

    private String dbUrl = "jdbc:mysql://localhost/savvas";
    private String dbClass = "com.mysql.jdbc.Driver";
    private String query = "Select * from comment";
    private String username = "root";
    private String password = "cstrike54321";
    private Connection connection;
    private Statement statement;


    public DbConnect() {

        try {
            Class.forName(dbClass);
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close() throws SQLException {
        connection.close();
    }

    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<Comment>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String comment = resultSet.getString("comment");
                Long id = resultSet.getLong("id");
                Timestamp createDate = resultSet.getTimestamp("create_date");

                Comment comment1 = new Comment(id, name, comment, createDate);
                comments.add(comment1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;

    }
    public void saveComment(Comment comment) {
        String givenName = comment.getName();
        String givenComment = comment.getComment();
        try {

            String toInsert = "insert into comment(`name`,`comment`) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(toInsert);
            statement.setString(1, givenName);
            statement.setString(2, givenComment);

            statement.execute();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteComment(Long id) throws SQLException {
        String toDelete = "delete from comment where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(toDelete);
        preparedStatement.setLong(1,id);
        preparedStatement.execute();

    }
}
