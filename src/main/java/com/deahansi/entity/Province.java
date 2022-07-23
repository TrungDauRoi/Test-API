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
@Table(name = "province")
public class Province {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    @Column(length = 36)
    private String Id;
    @Column(length = 50)
    private String Code;
    @Column(length = 50)
    private String Name;
    @Column(name = "order_No", length = 11)
    private Integer orderNo;
}
