package com.services.KhachHang;

import com.models.KhachHangModels.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhachHangService {

    Iterable<KhachHang> findAll();

    Page<KhachHang> findAllPaging(Pageable pageable);

    void them(KhachHang khachHang);

    KhachHang timTheoId(Long id);

    void xoaTheoId(Long id);

    Page<KhachHang> findAllByHoTenContaining(String hoTen, Pageable pageable);
}
