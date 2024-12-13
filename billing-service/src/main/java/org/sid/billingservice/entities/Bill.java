package org.sid.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.billingservice.model.Customer;

import java.util.Date;
import java.util.List;
@Entity @NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}

