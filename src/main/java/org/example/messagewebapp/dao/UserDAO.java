package org.example.messagewebapp.dao;

import lombok.Cleanup;
import org.example.messagewebapp.common.ConnectionUtil;
import org.example.messagewebapp.vo.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum UserDAO {
    INSTANCE;

    public Optional<UserVO> getUsers(String id, String pw) throws Exception{
        String query = """
                select * from tbl_user
                where
                    user_id= ?
                    and
                    password = ?
                """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,id);
        ps.setString(2,pw);
        @Cleanup ResultSet rs = ps.executeQuery();
        if(!rs.next()){
            return Optional.empty();
        }
        UserVO vo = UserVO.builder()
                .user_no(rs.getInt("user_no"))
                .user_id(rs.getString("user_id"))
                .user_name(rs.getString("user_name"))
                .password(rs.getString("password"))
                .role(rs.getString("role"))
                .build();
        return Optional.of(vo);
    }
    public List<UserVO> getAllStudents() throws Exception {
        String query = """
                select * from tbl_user
                where role = 'STUDENT'
                """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<UserVO> students = new ArrayList<>();
        while (rs.next()) {
            UserVO student = UserVO.builder()
                    .user_no(rs.getInt("user_no"))
                    .user_id(rs.getString("user_id"))
                    .user_name(rs.getString("username"))
                    .password(rs.getString("password"))
                    .role(rs.getString("role"))
                    .room_no(rs.getInt("room_no"))
                    .build();
            students.add(student);
        }
        return students;
    }

    public void assignRoom(String userId, int room_no) throws Exception {
        String query = """
                update tbl_user
                set room_no = ?
                where user_id = ?
                """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, room_no);
        ps.setString(2, userId);
        ps.executeUpdate();
    }
}
