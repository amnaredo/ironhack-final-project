package com.ironhack.coindex.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PositionUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private BigDecimal amount;
    private String description;
    @ManyToOne
    private Position position;
}
