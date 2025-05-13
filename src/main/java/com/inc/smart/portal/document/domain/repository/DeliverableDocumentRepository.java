package com.inc.smart.portal.document.domain.repository;

import com.inc.smart.portal.document.domain.entity.DeliverableDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliverableDocumentRepository extends JpaRepository<DeliverableDocument, Long> {
    @Query(value = """
        SELECT
            A.id AS id,
            A.name AS name,
            B.process_category_id AS processCategoryId,
            B.name AS deliverableTypeNm,
            C.deliverable_type_id AS deliverableTypeId,
            C.name AS deliverableDocumentTitle,
            C.document_type AS documentType
        FROM
            TB_PROCESS_CATEGORY A
        LEFT JOIN
            TB_DELIVERABLE_TYPE B ON A.id = B.process_category_id
        LEFT JOIN
            TB_DELIVERABLE_DOCUMENT C ON B.id = C.deliverable_type_id
        WHERE
            A.top_menu = :topMenu
       """,
            nativeQuery = true)
    List<Object[]> findProcessCategoryDetails(@Param("topMenu") int topMenu);

}
