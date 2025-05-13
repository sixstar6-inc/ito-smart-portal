package com.inc.smart.portal.document.domain.repository;

import com.inc.smart.portal.document.domain.entity.DeliverableDocument;
import com.inc.smart.portal.document.domain.entity.DeliverableType;
import com.inc.smart.portal.document.domain.entity.ProcessCategory;
import com.inc.smart.portal.document.domain.enums.DocumentType;
import com.inc.smart.portal.document.domain.enums.TopMenu;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class DeliverableDocumentRepositoryTest {

    @Autowired ProcessCategoryRepository processCategoryRepository;
    @Autowired DeliverableTypeRepository deliverableTypeRepository;
    @Autowired DeliverableDocumentRepository deliverableDocumentRepository;

    @Test
    @DisplayName("로드맵을 위한 데이터 조회 by Top menu code")
    void test_findAll_document_for_roadmap(){
        //given
        ProcessCategory savedCategory = processCategoryRepository.save(new ProcessCategory("사전단계", "icon-plan", TopMenu.PLANNING));
        DeliverableType deliverableType1 = DeliverableType.builder().title("컨센서스 미팅").processCategoryId(savedCategory.getId()).build();

        deliverableType1.addDocument(buildDeliverableType(DocumentType.GUIDE, "현업요구사항정의서"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "제안요청서초안"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "poc수행절차서"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "추정가격조서"));
        deliverableType1.addDocument(buildDeliverableType(DocumentType.PROCEDURE, "실무위원회지침"));

        deliverableTypeRepository.save(deliverableType1);

        List<Object[]> documents = deliverableDocumentRepository.findProcessCategoryDetails(TopMenu.PLANNING.getCode());
        assertThat(documents)
                .hasSize(5)
                .extracting(arr -> arr[5])
                .containsExactly("현업요구사항정의서","제안요청서초안","poc수행절차서","추정가격조서","실무위원회지침");

        for (Object[] document : documents) {
            //Class<?> clazz = document[0].getClass();
            //System.out.println("obj's class: " + clazz.getName());
            System.out.println("result[0] = " + document[0]);//long
            System.out.println("result[1] = " + document[1]);//string
            System.out.println("result[2] = " + document[2]);
            System.out.println("result[3] = " + document[3]);
            System.out.println("result[4] = " + document[4]);
            System.out.println("result[5] = " + document[5]);
            System.out.println("--------------------------------------");
        }
    }

    private static DeliverableDocument buildDeliverableType(DocumentType guide, String name) {
        return DeliverableDocument.builder().documentType(guide).url("-").title(name).build();
    }
}