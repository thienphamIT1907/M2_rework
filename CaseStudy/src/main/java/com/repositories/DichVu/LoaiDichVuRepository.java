package com.repositories.DichVu;

import com.models.DichVuModels.LoaiDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LoaiDichVuRepository extends JpaRepository<LoaiDichVu, Long> {
}
