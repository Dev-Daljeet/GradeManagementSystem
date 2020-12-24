package com.devdaljeet.grademanagementsystem.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class User {
	
	private Long userId;
	private String userName;
	private String encryptedPassword;
}
