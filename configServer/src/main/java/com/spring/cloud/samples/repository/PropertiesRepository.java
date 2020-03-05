package com.spring.cloud.samples.repository;

import java.util.List;
import java.util.Optional;

import com.spring.cloud.samples.domain.Properties;

import org.springframework.data.repository.CrudRepository;

/**
 * @author TTDKOC
 *
 */
public interface PropertiesRepository extends CrudRepository<Properties, Long> {

	public List<Properties> findByApplication(String application);

	public List<Properties> findByApplicationAndProfile(String application, String profile);

	public List<Properties> findByApplicationAndProfileAndLabel(String application, String profile, String label);

	public List<Properties> findByApplicationAndProfileAndLabelAndSetting(String application, String profile,
			String label, String key);

	public Optional<Properties> findOneByApplicationAndProfileAndLabelAndSetting(String application, String profile,
			String label, String key);

}
