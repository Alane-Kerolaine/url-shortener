package com.dts.encurtadordeurl.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String originalUrl;
    private String shortUrl;
    private Integer clickCounter;
}
