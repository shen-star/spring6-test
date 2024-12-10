package com.shen.jdbc;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JdbcTemplateTest {
    private static final Logger logger = LoggerFactory.getLogger(JdbcTemplateTest.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //测试SQL中数据操作功能:DML-新增，更新，删除
    @Test
    public void testDML() {
        //新增操作
        String insertSql = "insert into student values(null,?,?,?)";
        Object[] insertParams = {"小王", "20", "未知"};
        int row;
        row = jdbcTemplate.update(insertSql, insertParams);
        logger.info("新增结果为:{}", row);
        //更新操作
        String updateSql = "update student set sex=? where id=?";
        row = jdbcTemplate.update(updateSql, "男性", 1);
        logger.info("更新结果为:{}", row);
        //删除操作
        String deleteSql = "delete from student where id =?";
        row = jdbcTemplate.update(deleteSql, 1);
        logger.info("删除结果为:{}", row);
    }

    //测试SQL中数据查询功能:DQL
    @Test
    public void testDQL() {
        //插入一些数据
        insertData();
        //查询一个对象数据
        selectObjectData();
        //查询一个对象集合
        selectObjectList();
        //查询特定的值
        selectOneValue();
    }

    //插入数据
    public void insertData() {
        String insertSql = "insert into student values(null,?,?,?)";
        Object[] insertOneParams = {"小王", "20", "男"};
        Object[] insertTwoParams = {"小张", "18", "女"};
        Object[] insertThreeParams = {"小刘", "21", "女"};
        int row;
        row = jdbcTemplate.update(insertSql, insertOneParams);
        logger.info("新增结果为:{}", row);
        row = jdbcTemplate.update(insertSql, insertTwoParams);
        logger.info("新增结果为:{}", row);
        row = jdbcTemplate.update(insertSql, insertThreeParams);
        logger.info("新增结果为:{}", row);
    }

    //查询一个对象数据
    public void selectObjectData() {
        //写法一，自定义RowMapper
        String selectSql = "select * from student where id =?";
        StudentEntity studentEntityOne = jdbcTemplate.queryForObject(selectSql,
                (rs, rowNum) -> {
                    StudentEntity student = new StudentEntity();
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setAge(rs.getInt("age"));
                    student.setSex(rs.getString("sex"));
                    return student;
                }, 2);
        logger.info("[查询一个对象] 写法一:查询一个对象的结果为:{}", studentEntityOne);
        //写法二，使用RowMapper实现类 BeanPropertyRowMapper
        StudentEntity studentEntityTwo = jdbcTemplate.queryForObject(selectSql, new BeanPropertyRowMapper<>(StudentEntity.class), 2);
        logger.info("[查询一个对象] 写法二:查询一个对象的结果为:{}", studentEntityTwo);
    }

    //查询一个对象集合
    public void selectObjectList() {
        String selectSql = "select * from student";
        List<StudentEntity> studentEntityList = jdbcTemplate.query(selectSql, new BeanPropertyRowMapper<>(StudentEntity.class));
        logger.info("[查询一个对象集合] 结果为:{}", studentEntityList);
    }

    //查询特定的值
    public void selectOneValue() {
        String selectSql = "select count(*) from student";
        Integer integer = jdbcTemplate.queryForObject(selectSql, Integer.class);
        logger.info("[查询一个特定值] 结果为:{}", integer);
    }

}
