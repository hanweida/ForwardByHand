package com.jerry.c3p0datasource.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TestServiceImple {
    @Autowired
    private DataSource dataSource;

    public String invoke() throws SQLException {
        String sql = "select * from student";
        String sql2 = "create table `student` (\n" +
                "                           `id` double ,\n" +
                "                           `name` varchar (30),\n" +
                "                           `clazz` varchar (30),\n" +
                "                           `age` double ,\n" +
                "                           `mark` varchar (300)\n" +
                ");";
        Connection connection = dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.executeUpdate();
        preparedStatement.close();

        String sql3= "insert into `student` (`id`, `name`, `clazz`, `age`, `mark`) values('1','tomcat','动物城1班','8','非常淘气');\n";
        String sql4= "insert into `student` (`id`, `name`, `clazz`, `age`, `mark`) values('2','jerry','动物城1班','4','古灵精怪');";

        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
        preparedStatement3.executeUpdate();
        preparedStatement3.close();


        PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
        preparedStatement4.executeUpdate();
        preparedStatement4.close();

        PreparedStatement preparedStatement5 = connection.prepareStatement(sql);


        ResultSet resultSet = preparedStatement5.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement5.close();
        connection.close();

        return "Controller GetDataSourceExample.hello() is running!!";
    }
}
