package com.services.DichVu.impl;

import com.models.DichVuModels.HopDongChiTiet;
import com.repositories.DichVu.HopDongChiTietRepository;
import com.services.DichVu.HopDongChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HopDongChiTietImpl implements HopDongChiTietService {

    @Autowired
    HopDongChiTietRepository hopDongChiTietRepository;

    @Override
    public Iterable<HopDongChiTiet> findAll() {
        return hopDongChiTietRepository.findAll();
    }

    @Override
    public void them(HopDongChiTiet hopDongChiTiet) {
        hopDongChiTietRepository.save(hopDongChiTiet);
    }

    @Override
    public HopDongChiTiet timTheoId(Long id) {
        return hopDongChiTietRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        hopDongChiTietRepository.deleteById(id);
    }
}
