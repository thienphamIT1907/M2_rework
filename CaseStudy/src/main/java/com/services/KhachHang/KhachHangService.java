package com.services.KhachHang;

import com.models.KhachHangModels.KhachHang;

import java.util.List;

public interface KhachHangService {

    List<KhachHang> findAll();

    void them(KhachHang khachHang);

    KhachHang timTheoId(Long id);

    void xoaTheoId(Long id);
}
