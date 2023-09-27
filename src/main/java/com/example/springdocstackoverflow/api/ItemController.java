package com.example.springdocstackoverflow.api;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdocstackoverflow.model.Item;
import com.example.springdocstackoverflow.model.ItemRepository;

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
}
