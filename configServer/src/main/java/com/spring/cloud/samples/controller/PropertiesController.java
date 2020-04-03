package com.spring.cloud.samples.controller;

import com.spring.cloud.samples.domain.Properties;
import com.spring.cloud.samples.repository.PropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PropertiesController {

	@Autowired
	private PropertiesRepository repository;

	@GetMapping("/props")
	public Iterable<Properties> getAll() {
		return repository.findAll();
	}

	@GetMapping("/props/{application}")
	public Iterable<Properties> get(@PathVariable() String application) {
		return repository.findByApplication(application);
	}

	@GetMapping("/props/{application}/{profile}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile) {
		return repository.findByApplicationAndProfile(application, profile);
	}

	@GetMapping("/props/{application}/{profile}/{label}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
			@PathVariable() String label) {
		return repository.findByApplicationAndProfileAndLabel(application, profile, label);
	}

	@GetMapping("/props/{application}/{profile}/{label}/{key}")
	public Iterable<Properties> get(@PathVariable() String application, @PathVariable() String profile,
			@PathVariable() String label, @PathVariable() String key) {
		return repository.findByApplicationAndProfileAndLabelAndSetting(application, profile, label, key);
	}

	@PutMapping("/props")
	public Optional<Properties> update(@Valid @RequestBody Properties insuranceProperties) throws URISyntaxException {
		Optional<Properties> existing = repository.findOneByApplicationAndProfileAndLabelAndSetting(
				insuranceProperties.getApplication(), insuranceProperties.getProfile(), insuranceProperties.getLabel(),
				insuranceProperties.getSetting());
		return existing.map(rProp -> {
			rProp.setValue(insuranceProperties.getValue());
			return repository.save(rProp);
		});
	}

	@PostMapping("/props")
	public Properties create(@Valid @RequestBody Properties insuranceProperties) {
		return repository.save(insuranceProperties);
	}
}
