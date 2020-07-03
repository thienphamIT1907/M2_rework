package com.repositories.NhanVien;

import com.models.NhanVienModels.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {
}
