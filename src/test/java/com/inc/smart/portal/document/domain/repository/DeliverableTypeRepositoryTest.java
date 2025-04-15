package com.inc.smart.portal.document.domain.repository;

import com.inc.smart.portal.document.domain.DeliverableDocument;
import com.inc.smart.portal.document.domain.DeliverableType;
import com.inc.smart.portal.document.domain.enums.DocumentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DeliverableTypeRepositoryTest {

    @Autowired
    DeliverableTypeRepository deliverableTypeRepository;
    @Autowired DeliverableDocumentRepository deliverableDocumentRepository;


    @Test
    @DisplayName("데이터 조회 by Process Category Id")
    void test_findAll_DeliverableTypes_by_ProcessCategoryId(){
        DeliverableType deliverableType1 = DeliverableType.builder().title("컨센서스 미팅").processCategoryId(1L).build();

        deliverableType1.addDocument(buildDeliverableType(DocumentType.GUIDE, "현업요구사항정의서"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "제안요청서초안"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "poc수행절차서"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "추정가격조서"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "실무위원회지침"));

        deliverableTypeRepository.save(deliverableType1);

        List<DeliverableType> results = deliverableTypeRepository.findByProcessCategoryId(1L);
        assertThat(results).hasSize(1)
                .flatExtracting(DeliverableType::getDocuments)
                .hasSize(5)
                .extracting("name")
                .containsExactly("현업요구사항정의서","제안요청서초안","poc수행절차서","추정가격조서","실무위원회지침");
    }

    private static DeliverableDocument buildDeliverableType(DocumentType guide, String name) {
        return DeliverableDocument.builder().documentType(guide).url("-").title(name).build();
    }


}