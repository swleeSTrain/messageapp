package org.example.messagewebapp.vo;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageVO {
    private Integer message_no;
    private String sender_id;
    private String receiver_id;
    private String message_content;
    private boolean all_send;
    private boolean delflag;
    private Timestamp timestamp;
}
