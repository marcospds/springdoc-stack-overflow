package com.example.springdocstackoverflow.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(callSuper = true)
@Accessors(chain = true)
@JsonIgnoreProperties("handler")
@Schema(name = "Item", description = "I.t.e.m")
@Entity
@TableName(value = "item", autoResultMap = true)
public class Item extends Model<Item> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableId(value = "id", type = IdType.AUTO)
	@Schema(description = "ID", type = "integer", name = "id")
	private Long id;

	@TableField(value = "name")
	@Schema(description = "Name", type = "string", name = "name")
	private String name;

	public Item(String name) {
		this.name = name;
	}
}
