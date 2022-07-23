package com.deahansi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "nre_type")
public class NreType {
  private static final long serialVersionUID = 1L;

  @Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@GeneratedValue(generator = "uuid2")
	@Column(length = 36)
  private String id;

  @Column(length = 50)
  private String code;
  @Column(length = 50)
  private String name;
  @Column(length = 50)
  private String description;
  @Column(name = "order_no")
  private Integer orderNo;
}
