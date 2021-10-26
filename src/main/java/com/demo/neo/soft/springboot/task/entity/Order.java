package com.demo.neo.soft.springboot.task.entity;
  
  import java.util.Date;
  import java.util.Set;
  
  import javax.persistence.CascadeType;
  import javax.persistence.Entity;
  import javax.persistence.FetchType;
  import javax.persistence.GeneratedValue;
  import javax.persistence.GenerationType;
  import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.neo.soft.springboot.task.utils.Constants;

import lombok.AllArgsConstructor;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  import lombok.Setter;
  import lombok.ToString;
  
  @ToString 
  @Getter  
  @Setter  
  @AllArgsConstructor  
  @NoArgsConstructor  
  @Entity  
  @Table(name="ORDER")
  public class Order extends Auditable<String>{
  
  @Id
  @GeneratedValue(generator = Constants.UUID)
  @GenericGenerator(name = Constants.UUID, strategy = Constants.UUID)
  private String orderId;
  
  private String orderNo;
  
  private String totalOrder;
  
  private String totalQty;
 
  
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "ref_user_Id", referencedColumnName = "userId")
  private User user;
  
  }
 
 
 