package com.example.demo.dao;

import com.example.demo.entity.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @description
* @author Tim Lin
* @create 2018-07-01
**/
@Mapper
public interface StudentDAO {

    @Select(value = "SELECT * FROM student")
    List<Student> getAllStudent();

    @Select(value = "SELECT * FROM user")
    List<User> getAllUser();

    @Select(value = "SELECT * FROM user where user.`userName` = #{userName}")
    User verify(User user);

    @Insert(value = "INSERT INTO user(user.`userName`,user.`passWord`,user.`name`,user.`gender`,user.`birthday`,user.`address`,user.`conWay`,user.`referrer`,user.`assoName`,user.`isAdmin`)\n" +
            "VALUE(#{userName},#{passWord},#{name},#{gender},#{birthday},#{address},#{conWay},#{referrer},#{assoName},#{isAdmin})")
    int insert(User user);

    @Insert(value = "INSERT INTO comment(comment.`id`,comment.`name`,comment.`content`) VALUES (#{id},#{name},#{content})")
    int insertCon(@Param("id") int id, @Param("name")String name, @Param("content")String content);

    @Select(value = "SELECT * FROM comment")
    List<Comment> getAllComment();

    @Select(value = "SELECT * FROM comment where id = #{id}")
    List<Comment> getComment(int id);

    @Select(value = "SELECT * FROM proposal where id = #{id}")
    Proposal getProposal(int id);

    @Select(value = "SELECT * FROM user WHERE `username` = #{username}")
    User getUser(String username);

    @Select(value = "SELECT * FROM referrer WHERE `name` = #{name}")
    Referrer getReferrer(String name);

    @Select(value = "SELECT * FROM proposal")
    List<Proposal> getAllProposal();

}
