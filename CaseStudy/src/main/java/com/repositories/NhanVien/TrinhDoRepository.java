package com.repositories.NhanVien;

import com.models.NhanVienModels.TrinhDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface TrinhDoRepository extends JpaRepository<TrinhDo, Long> {
}
