package cn.dbdj1201.lazyman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tyz1201
 * @datetime 2020-03-13 17:35
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("list")
    public String listRole() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from role");
        ResultSet rs = pstm.executeQuery();
        List<Object> list = new ArrayList<>();

        while (rs.next()) {
            Object obj = new Object();
            list.add(rs.getInt(1));
            list.add(rs.getString(2));
            list.add(rs.getString(3));
        }
        System.out.println(list);
        return "text/json";
    }

}
