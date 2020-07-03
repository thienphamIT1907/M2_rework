package com.services.KhachHang.impl;

import com.models.KhachHangModels.LoaiKhachHang;
import com.repositories.KhachHang.LoaiKhachHangRepository;
import com.services.KhachHang.LoaiKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiKhachHangServiceImpl implements LoaiKhachHangService {

    @Autowired
    LoaiKhachHangRepository loaiKhachHangRepository;

    @Override
    public List<LoaiKhachHang> findAll() {
        return loaiKhachHangRepository.findAll();
    }
}
