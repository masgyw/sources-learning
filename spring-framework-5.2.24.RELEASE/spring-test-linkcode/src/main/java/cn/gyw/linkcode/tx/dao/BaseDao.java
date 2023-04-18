package cn.gyw.linkcode.tx.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @date 2023/4/18
 */
@Repository
public class BaseDao {

    public static final String TABLE_NAME = "t";

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 参数替换方式插入
     */
    public boolean insertBySqlParams(int id, String name) {
        String insertSql = "INSERT INTO " + TABLE_NAME +" (id, `name` ) VALUES( ?,?)";
        return jdbcTemplate.update(insertSql, id, name) > 0;
    }

    /**
     * 通过Statement方式插入
     */
    public boolean insertByStatement(int id, String name) {
        String insertSql = "INSERT INTO " + TABLE_NAME +" (id, `name` ) VALUES( ?,?)";
        return jdbcTemplate.update(insertSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
                ps.setString(2, name);
            }
        }) > 0;
    }
}
