package com.chovietz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.chovietz.model.Shipper;
import com.chovietz.repository.ShipperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/shipper")
@CrossOrigin(origins= "*", maxAge=3600)
public class ShipperController {
    @Autowired
    private ShipperRepository shipperRepository;
    @RequestMapping("")
	@ResponseBody
	public ResponseEntity<?> getAllShipperByWorkArea(
	@RequestParam(required = true) String work_city,@RequestParam(required = true) String work_district,@RequestParam(required = false) String work_ward) {
		try {   
			if(work_city == null|| work_district == null){
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Shipper shipper  = new Shipper();
            shipper.setWork_city(work_city);
            shipper.setWork_district(work_district);
            if(work_ward != null){
                shipper.setWork_ward(work_ward);
            }
            System.out.println(shipper.getWork_city());
			Example<Shipper> example = Example.of(shipper,ExampleMatcher.matching()
			.withIgnorePaths("_class")
			);

			List<Shipper> shipperList  = shipperRepository.findAll(example);
 
				System.out.println(shipperList);
		
			Map<String, Object> response = new HashMap<>();
			response.put("shippers", shipperList);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
                System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> getShipperInfo(@PathVariable("id") String id) {
		Optional<Shipper> shipper = shipperRepository.findById(id);
		if (shipper.isPresent()) {
			Shipper _shipper = shipper.get();
			_shipper.setPassword(null);
			return new ResponseEntity<Shipper>(_shipper,HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
