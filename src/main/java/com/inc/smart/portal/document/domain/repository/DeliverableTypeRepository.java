package com.inc.smart.portal.document.domain.repository;

import com.inc.smart.portal.document.domain.entity.DeliverableType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeliverableTypeRepository extends JpaRepository<DeliverableType, Long> {

    @Query("select c from DeliverableType c join fetch c.documents where c.processCategoryId = :processCategoryId") //fetch join 즉시 로딩
    List<DeliverableType> findByProcessCategoryId(@Param("processCategoryId") Long processCategoryId);
}