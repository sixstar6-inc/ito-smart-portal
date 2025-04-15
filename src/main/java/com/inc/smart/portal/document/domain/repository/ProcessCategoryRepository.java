package com.inc.smart.portal.document.domain.repository;

import com.inc.smart.portal.document.domain.ProcessCategory;
import com.inc.smart.portal.document.domain.enums.TopMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProcessCategoryRepository extends JpaRepository<ProcessCategory, Long> {
    List<ProcessCategory> findByTopMenu(TopMenu topMenu);
}