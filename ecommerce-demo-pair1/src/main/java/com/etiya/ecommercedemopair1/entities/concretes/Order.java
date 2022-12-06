package com.etiya.ecommercedemopair1.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "isCompleted")
    private boolean isCompleted;


    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnoreProperties("Order")
    private Address address;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties("Order")
    private List<OrderDelivery> orderDeliveries;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties("Order")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties("Order")
    private List<Payment> payments;
}
