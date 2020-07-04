package com.services.DichVu;

import com.models.DichVuModels.HopDongChiTiet;

public interface HopDongChiTietService {

    Iterable<HopDongChiTiet> findAll();

    void them(HopDongChiTiet hopDongChiTiet);

    HopDongChiTiet timTheoId(Long id);

    void xoaTheoId(Long id);
}
