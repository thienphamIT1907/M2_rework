package com.services.KhachHang.impl;

import com.models.KhachHangModels.KhachHang;
import com.repositories.KhachHang.KhachHangRepository;
import com.services.KhachHang.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public Iterable<KhachHang> findAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> findAllPaging(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public void them(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang timTheoId(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public Page<KhachHang> findAllByHoTenContaining(String hoTen, Pageable pageable) {
        return khachHangRepository.findAllByHoTenContaining(hoTen, pageable);
    }
}
