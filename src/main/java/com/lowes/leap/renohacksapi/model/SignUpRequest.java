package com.lowes.leap.renohacksapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    private int cupstomerId;
    private String customerName;
    private String customerMobNo;
    private String customerEmail;
    private String customerAddress;
    private String password;
    private String userName;
    private int userId;
}
