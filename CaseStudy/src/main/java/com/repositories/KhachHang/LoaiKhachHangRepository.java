package com.repositories.KhachHang;

import com.models.KhachHangModels.LoaiKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaiKhachHangRepository extends JpaRepository<LoaiKhachHang, Long> {
}
