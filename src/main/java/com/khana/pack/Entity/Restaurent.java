package com.khana.pack.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="Resturent_Names")
public class Restaurent {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String location;
	    private String description;
	    private String contact;
	    
	    @Column(nullable = false, columnDefinition = "DOUBLE DEFAULT 0.0")
	    private double rating;

}

