package com.demo.neo.soft.springboot.task.entity;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.neo.soft.springboot.task.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "USER_TASK")
public class User extends Auditable<String>{

	@Id
    @GeneratedValue(generator = Constants.UUID)
    @GenericGenerator(name = Constants.UUID, strategy = Constants.UUID)
	@Column(name="userId")
	private String userId;

	private String userName;

	private String email;

	private String mobile;

	private boolean isActive;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> userAddress;
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
	private List<Order> order;
}
