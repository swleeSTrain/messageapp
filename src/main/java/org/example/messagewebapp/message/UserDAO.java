package org.example.messagewebapp.message;

import lombok.Cleanup;
import org.example.messagewebapp.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public enum UserDAO {
    INSTANCE;

    public Optional<UserVO> get(String id,String pw) throws Exception{
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
                .user_name(rs.getString("username"))
                .password(rs.getString("password"))
                .role(rs.getString("role"))
                .build();
        return Optional.of(vo);
    }
}
