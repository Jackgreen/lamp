package com.jack.general.abst;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public abstract class AbstractDao {
    private static final Logger logger = LogManager.getLogger();

    protected static final String ACCOUNTMAPPER = "com.netease.antispam.account.AccountMapper.";

    @Resource(name = "sqlSessionTemplate")
    protected SqlSessionTemplate sqlSessionTemplate;

    protected SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    protected String getStatement(String subId, Class<?> clazz) {
        return clazz.getName() + "Mapper." + subId;
    }

    public long getGeneratId(String tableName) {
        long key = 0;
        Connection connection = null;
        Statement stmt = null;
        ResultSet resultSet = null;
        try {
            connection = getSqlSessionTemplate().getConfiguration().getEnvironment().getDataSource().getConnection();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT allocate_record_id FROM " + tableName);
            if (resultSet != null) {
                if (resultSet.next()) {
                    key = resultSet.getLong(1);
                }
            }
        } catch (SQLException e) {
            logger.error(String.format("get table generateid error=%s", e.getMessage()), e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e2) {
                    logger.error(e2.getMessage(), e2);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e3) {
                    logger.error(e3.getMessage(), e3);
                }
            }
        }
        return key;
    }
}
