package com.khana.pack.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Menu_Items")
public class MenuItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category; // E.g., "Starter", "Main Course", "Dessert"

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurent restaurant;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderFood order;
   
}













