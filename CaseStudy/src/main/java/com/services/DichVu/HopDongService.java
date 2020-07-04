package com.services.DichVu;

import com.models.DichVuModels.HopDong;

public interface HopDongService {

    Iterable<HopDong> findAll();

    void them(HopDong hopDong);

    HopDong timTheoId(Long id);

    void xoaTheoId(Long id);

}
