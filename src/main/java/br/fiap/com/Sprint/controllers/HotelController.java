package br.fiap.com.Sprint.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.fiap.com.Sprint.dtos.HotelDto;
import br.fiap.com.Sprint.models.HotelModel;
import br.fiap.com.Sprint.services.HotelService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	final HotelService hotelService;
	
	public HotelController(HotelService hotelService) {
		this.hotelService = hotelService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveHotel(@RequestBody @Valid HotelDto hoteldto) {
		var HotelModel = new HotelModel();
		BeanUtils.copyProperties(hoteldto, HotelModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.save(HotelModel));
		
		
	}
	
	@GetMapping
	public ResponseEntity<List<HotelModel>> getAllHotel() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneHotel(@PathVariable(value = "id") long id){
		Optional<HotelModel> HotelModelOptional = hotelService.findById(id);
		if (!HotelModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(HotelModelOptional.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteHotel(@PathVariable(value="id") long id) {
		Optional<HotelModel> hotelModelOptional = hotelService.findById(id);
		if(!hotelModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not Found");
		}
		hotelService.delete(hotelModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Hotel deleted.");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateHotel(@PathVariable(value = "id") long id,
												@RequestBody @Valid HotelDto hotelDto){
		Optional<HotelModel> hotelModelOptional = hotelService.findById(id);
		if(!hotelModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel not Found");
		}
		var hotelModel = new HotelModel();		
		BeanUtils.copyProperties(hotelDto, hotelModel);
		hotelModel.setCd_hotel(hotelModelOptional.get().getCd_hotel());
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.save(hotelModel));
		
		
	}
	
	
}
