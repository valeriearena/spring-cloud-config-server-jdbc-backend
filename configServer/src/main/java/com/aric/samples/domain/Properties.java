/**
 * 
 */
package com.aric.samples.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author TTDKOC
 *
 */
@Entity
@Data
public class Properties implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String application;
	private String profile;
	private String label;
	private String setting;
	private String value;
}
