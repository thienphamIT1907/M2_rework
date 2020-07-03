package com.services.KhachHang.impl;

import com.models.KhachHangModels.KhachHang;
import com.repositories.KhachHang.KhachHangRepository;
import com.services.KhachHang.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;


    @Override
    public List<KhachHang> findAll() {
        return khachHangRepository.findAll();
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
}
