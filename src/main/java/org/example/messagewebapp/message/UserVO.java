package org.example.messagewebapp.message;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {
    private int user_no;
    private String user_id;
    private String user_name;
    private String password;
    private String role;
    private int room_no;
}
