package com.services.NhanVien.impl;

import com.models.NhanVienModels.NhanVien;
import com.repositories.NhanVien.NhanVienRepository;
import com.services.NhanVien.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void them(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien timTheoId(Long id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        nhanVienRepository.deleteById(id);
    }
}
