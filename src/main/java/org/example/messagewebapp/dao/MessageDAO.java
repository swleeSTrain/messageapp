package org.example.messagewebapp.dao;

import lombok.Cleanup;
import org.example.messagewebapp.common.ConnectionUtil;
import org.example.messagewebapp.vo.MessageVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public enum MessageDAO {
    INSTANCE;

    public List<MessageVO> getMessage(String id) throws Exception {
        String query = """
                select *
                from tbl_message
                where sender_id = ? or receiver_id = ? 
                order by message_no desc
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
    public void sendMessage(MessageVO vo) throws Exception {
        String query = """
                insert into tbl_message (sender_id, receiver_id, message_content)
                values(?,?,?)
                """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, vo.getSender_id());
        ps.setString(2, vo.getReceiver_id());
        ps.setString(3, vo.getMessage_content());
        ps.executeUpdate();
    }

}
