/**
 *
 */
package com.spring.cloud.samples.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Properties implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String application;
	private String setting;
	private String value;
	private String profile;
	private String label;

}
