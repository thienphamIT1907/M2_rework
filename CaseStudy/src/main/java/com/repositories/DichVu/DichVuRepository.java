package com.repositories.DichVu;

import com.models.DichVuModels.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface DichVuRepository extends JpaRepository<DichVu, Long> {

    Page<DichVu> findAllByTenDichVuContaining(String tenDichVu, Pageable pageable);
}
