package com.services.KhachHang;

import com.models.KhachHangModels.LoaiKhachHang;

import java.util.List;

public interface LoaiKhachHangService {

    Iterable<LoaiKhachHang> findAll();

    LoaiKhachHang timTheoId(Long id);
}
