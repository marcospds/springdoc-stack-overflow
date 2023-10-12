package com.example.springdocstackoverflow.api;

import java.util.Optional;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdocstackoverflow.model.Item;
import com.example.springdocstackoverflow.model.ItemRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

	private ItemRepository itemRepository;

	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@GetMapping
	public Slice<Item> getAll(@ParameterObject Pageable pageable) {
		return itemRepository.findAll(pageable);
	}
	
	@GetMapping("/{id}")
	public Optional<Item> get(@PathVariable("id") Long id) {
		return itemRepository.findById(id);
	}
}
