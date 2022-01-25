package com.chovietz.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chovietz.model.Order;
import com.chovietz.model.ReturnOrder;
import com.chovietz.repository.ReturnOrderRepository;

@RestController
@RequestMapping("api/return-order")
@CrossOrigin( maxAge=3600)
public class ReturnOrderController {
	@Autowired
    private ReturnOrderRepository returnOrderRepository;
	  @RequestMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> getUserInfo(@PathVariable("id") String id) {
        System.out.println(id);
		Optional<ReturnOrder> returnOrder = returnOrderRepository.findById(id);
		if (returnOrder.isPresent()) {
			ReturnOrder _returnOrder = returnOrder.get();
            
			return new ResponseEntity<ReturnOrder>(_returnOrder,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    @PostMapping("")
    public ResponseEntity<?> createReturnOrder(@RequestBody ReturnOrder orderReq){
        
       try {
           orderReq.setCreated_date(new Date());
        orderReq.setUpdated_date(new Date());
            return new ResponseEntity<>(returnOrderRepository.save(orderReq), HttpStatus.OK);
       } catch (Exception e) {
           //TODO: handle exception
           System.out.println(e.toString());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
       
    }
    @PutMapping("/{id}/new-order")
    public ResponseEntity<?> updateReturnOrder(@PathVariable("id") String id,@RequestBody Order new_order){
        
       	Optional<ReturnOrder> orderData = returnOrderRepository.findById(id);
		if (orderData.isPresent()) {
			ReturnOrder _order = orderData.get();
			_order.setNew_order(new_order);
			_order.setUpdated_date(new Date());
			return new ResponseEntity<>(returnOrderRepository.save(_order), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
       
    }
  
}
