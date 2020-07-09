package com.services.DichVu.impl;

import com.models.DichVuModels.HopDong;
import com.repositories.DichVu.HopDongRepository;
import com.services.DichVu.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HopDongServiceImpl implements HopDongService {

    @Autowired
    HopDongRepository hopDongRepository;

    @Override
    public Iterable<HopDong> findAll() {
        return hopDongRepository.findAll();
    }

    @Override
    public void them(HopDong hopDong) {
        hopDongRepository.save(hopDong);
    }

    @Override
    public HopDong timTheoId(Long id) {
        return hopDongRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        hopDongRepository.deleteById(id);
    }

    @Override
    public Iterable<HopDong> findAllByKhachHang_IdKhachHang(Long id) {
        return hopDongRepository.findAllByKhachHang_IdKhachHang(id);
    }
}
