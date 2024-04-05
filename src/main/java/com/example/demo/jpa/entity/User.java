package com.example.demo.jpa.entity;






import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "T_USER")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql= " UPDATE T_USER SET enabled = false where id = ?")
@SQLRestriction(value = "enabled = true")
public class User extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String email;
	
	private String username;
	private String password;
	private int age;
}
