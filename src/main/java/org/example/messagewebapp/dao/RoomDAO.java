package org.example.messagewebapp.dao;

import lombok.Cleanup;
import org.example.messagewebapp.common.ConnectionUtil;
import org.example.messagewebapp.vo.RoomVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public enum RoomDAO {
    INSTANCE;

    public List<RoomVO> getAllRooms() throws Exception {
        String query = "SELECT * FROM tbl_room ORDER BY room_no";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        @Cleanup ResultSet rs = ps.executeQuery();

        List<RoomVO> rooms = new ArrayList<>();
        while (rs.next()) {
            RoomVO room = RoomVO.builder()
                    .room_no(rs.getInt("room_no"))
                    .room_name(rs.getString("room_name"))
                    .build();
            rooms.add(room);
        }
        return rooms;
    }

    public void addRoom(RoomVO vo) throws Exception {
        String query = """
                        insert into tbl_room (room_name) values (?)
                        """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, vo.getRoom_name());
        ps.executeUpdate();
    }

    public void deleteRoom(int room_no) throws Exception {
        String query = """
                    delete from tbl_room where room_no = ?
                    """;
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, room_no);
        ps.executeUpdate();
    }
    // 방 이름가져오기
    public String getRoomNameByNo(int room_no) throws Exception {
        String query = "SELECT room_name FROM tbl_room WHERE room_no = ?";
        @Cleanup Connection con = ConnectionUtil.INSTANCE.getDs().getConnection();
        @Cleanup PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, room_no);
        @Cleanup ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString("room_name");
        }
        return null;
    }
}
