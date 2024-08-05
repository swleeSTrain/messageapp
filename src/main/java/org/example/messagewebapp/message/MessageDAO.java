package org.example.messagewebapp.message;

import lombok.Cleanup;
import org.apache.logging.log4j.message.Message;
import org.example.messagewebapp.common.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum MessageDAO {
    INSTANCE;

    public List<MessageVO> getMessage(String id) throws Exception {
        String query = """
                select *
                from tbl_message
                where sender_id = ? or receiver_id = ? 
                limit 10
                """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, id);
        ps.setString(2, id);
        @Cleanup ResultSet rs = ps.executeQuery();
        List<MessageVO> messages = new ArrayList<>();
        while (rs.next()) {
            MessageVO vo = MessageVO.builder()
                    .message_no(rs.getInt("message_no"))
                    .sender_id(rs.getString("sender_id"))
                    .receiver_id(rs.getString("receiver_id"))
                    .message_content(rs.getString("message_content"))
                    .all_send(rs.getBoolean("all_send"))
                    .delflag(rs.getBoolean("delflag"))
                    .timestamp(rs.getTimestamp("timestamp"))
                    .build();
            messages.add(vo);
        }

        return messages;
    }
}
