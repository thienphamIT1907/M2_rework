package com.services.NhanVien.impl;

import com.models.NhanVienModels.BoPhan;
import com.repositories.NhanVien.BoPhanRepository;
import com.services.NhanVien.BoPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoPhanServiceImpl implements BoPhanService {

    @Autowired
    BoPhanRepository boPhanRepository;

    @Override
    public Iterable<BoPhan> findAll() {
        return boPhanRepository.findAll();
    }

    @Override
    public void them(BoPhan boPhan) {
        boPhanRepository.save(boPhan);
    }

    @Override
    public BoPhan timTheoId(Long id) {
        return boPhanRepository.findById(id).orElse(null);
    }

    @Override
    public void xoaTheoId(Long id) {
        boPhanRepository.deleteById(id);
    }
}
