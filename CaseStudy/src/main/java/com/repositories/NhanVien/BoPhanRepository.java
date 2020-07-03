package com.repositories.NhanVien;

import com.models.NhanVienModels.BoPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface BoPhanRepository extends JpaRepository<BoPhan, Long> {
}
