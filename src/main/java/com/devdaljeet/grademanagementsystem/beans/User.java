package com.devdaljeet.grademanagementsystem.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** Represents the user in the database.
 * @author Daljeet Singh (Dev-Daljeet)
 * @version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	private Long userId;
	private String userName;
	private String encryptedPassword;
}
