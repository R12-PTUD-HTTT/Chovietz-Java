package com.chovietz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chovietz.model.Shop;
import com.chovietz.model.ShopApply;
import com.chovietz.model.Store;
import com.chovietz.payload.MessageRes;
import com.chovietz.repository.ShopApplyRepository;
import com.chovietz.repository.ShopRepository;
import com.chovietz.repository.StoreRepository;



@RestController
@RequestMapping("api/admin")
@CrossOrigin(origins= "*", maxAge=3600)
public class AdminController {
	@Autowired
    private ShopApplyRepository ShopApplyRepo;
	@Autowired
	private ShopRepository ShopRepo;
	@Autowired
	private StoreRepository StoreRepo;
	
	
	@Autowired
    PasswordEncoder encoder;
	
	@RequestMapping("/getshopapply")
	@ResponseBody
	public ResponseEntity<?> getShopApply () {
		List<ShopApply> shopApplyData = ShopApplyRepo.findAll();
		if(shopApplyData.size() == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(shopApplyData, HttpStatus.OK);
		}
	}
	@RequestMapping("/createshopacc/{id}")
	@ResponseBody
	public ResponseEntity<?> createShopAccount (@PathVariable("id") String id) {
		Optional<ShopApply> shopApplyData = ShopApplyRepo.findById(id);
		if (shopApplyData.isPresent()) {
			ShopApply _form = shopApplyData.get();
			Shop shopAcc = new Shop();
			
			if(ShopRepo.findByUsername(_form.getEmail()) != null) {
				return new ResponseEntity<>(new MessageRes("Email đã được sử dụng"),HttpStatus.BAD_REQUEST);
			}
			else {
				shopAcc.setUsername(_form.getEmail());
				shopAcc.setRolename("shop");
				shopAcc.setPassword(encoder.encode(_form.getCmnd()));
				shopAcc.setDate_of_birth(_form.getNgaysinh());
				shopAcc.setEmail(_form.getEmail());
				shopAcc.setName(_form.getHoten());
				shopAcc.setPhoneNumber(_form.getSdt());
				
				Store store = new Store();
				store.setStore_name(_form.getHoten());
				store.setPhone_number(_form.getSdt());
				store.setAddress(_form.getDiachi());
				
				StoreRepo.save(store);
				Store storeInfo = new Store();
				storeInfo.set_id(store.get_id());
				storeInfo.setStore_name(store.getStore_name());
				storeInfo.setPhone_number(store.getPhone_number());
				shopAcc.setStoreInfo(storeInfo);
				return new ResponseEntity<Shop>(ShopRepo.save(shopAcc),HttpStatus.OK);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
