package com.repositories.DichVu;

import com.models.DichVuModels.KieuThue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface KieuThueRepository extends JpaRepository<KieuThue, Long> {
}
