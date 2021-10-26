package com.demo.neo.soft.springboot.task.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.neo.soft.springboot.task.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.JoinColumn;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product extends Auditable<String>{

	@Id
	@GeneratedValue(generator = Constants.UUID)
    @GenericGenerator(name = Constants.UUID, strategy = Constants.UUID)
	private String productId;

	private String productName;

	private String productSKU;

	private String price;

	private boolean isActive;

	private String qty;


}
