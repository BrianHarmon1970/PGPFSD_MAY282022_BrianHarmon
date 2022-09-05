package com.ecommerce.DAO;
import com.ecommerce.Entity.EUser ;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EUserDAO
{
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<EUser> getProducts(){
        return template.query("select ID, user_name, first_name, last_name from eusers",
                new RowMapper<EUser>(){
            public EUser mapRow(ResultSet rs, int row) throws SQLException {
                EUser e=new EUser();
                e.setID((long)rs.getInt(1));
                e.setUserName(rs.getString(2));
                e.setFirstName(rs.getString(3));
                e.setLastName(rs.getString(4));
                return e;
            }
        });
    }
}
