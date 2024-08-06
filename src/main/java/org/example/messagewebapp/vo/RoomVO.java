package org.example.messagewebapp.vo;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomVO {
    private Integer room_no;
    private String room_name;

}
