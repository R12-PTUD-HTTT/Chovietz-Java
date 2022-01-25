package com.chovietz.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "ReturnOrder")
public class ReturnOrder {
    @Id
	private String id;
	private Shipper shipper;
    private Order order;
    private Object[] product_return;
    private String reason;
    private Date created_date;
    private Date updated_date;
    
}
