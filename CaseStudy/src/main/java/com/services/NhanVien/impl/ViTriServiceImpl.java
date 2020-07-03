package com.services.NhanVien.impl;

import com.models.NhanVienModels.ViTri;
import com.repositories.NhanVien.ViTriRepository;
import com.services.NhanVien.ViTriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViTriServiceImpl implements ViTriService {

    @Autowired
    ViTriRepository viTriRepository;

    @Override
    public List<ViTri> findAll() {
        return viTriRepository.findAll();
    }

    @Override
    public void them(ViTri viTri) {
        viTriRepository.save(viTri);
    }

    @Override
    public ViTri timTheoId(Long id) {
        return viTriRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        viTriRepository.deleteById(id);
    }
}
