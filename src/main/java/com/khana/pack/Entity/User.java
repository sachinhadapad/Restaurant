package com.khana.pack.Entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="USER")
public class User {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotNull(message="name should be blank")
 @Size(min=2,message="minimum should be 2 letters")
 private String name;
 
 @NotNull(message="Email should be blank")
 @Email(message="Eamil should be valid format")
 private String email;
 
 @NotBlank(message="Address should be blank")
 @Size(min=5,max=10,message="Address between 5 to 10 characters")
 private String adress;
 
 
 @NotBlank(message="Phone number not be blank")
 private String phone;
 
 // Role can be "CUSTOMER" or "ADMIN"
 private String role;
 

 
 
}
