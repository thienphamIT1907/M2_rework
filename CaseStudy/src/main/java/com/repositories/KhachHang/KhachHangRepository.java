package com.repositories.KhachHang;

import com.models.KhachHangModels.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    Page<KhachHang> findAllByHoTenContaining(String hoTen, Pageable pageable);
}
