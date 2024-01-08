package backend.config.service;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableJpaRepositories(basePackages = {"backend.models.data"})
public interface DataISource {
}
