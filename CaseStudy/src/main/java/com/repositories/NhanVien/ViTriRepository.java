package com.repositories.NhanVien;

import com.models.NhanVienModels.ViTri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ViTriRepository extends JpaRepository<ViTri, Long> {
}
