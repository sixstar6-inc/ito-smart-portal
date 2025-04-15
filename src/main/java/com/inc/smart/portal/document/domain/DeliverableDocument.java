package com.inc.smart.portal.document.domain;

import com.inc.smart.portal.document.common.entity.NamedEntity;
import com.inc.smart.portal.document.domain.enums.DocumentType;
import jakarta.persistence.*;
import lombok.*;

/**
 * 3Depth 에 해당하는 실제 산출물 문서를 나타내는 클래스입니다.
 * 예: 요구사항 명세서 문서, 제안요청서 초안등
 */
@ToString
@Getter
@NoArgsConstructor
@Table(name = "TB_DELIVERABLE_DOCUMENT")
@Entity
public class DeliverableDocument extends NamedEntity {

    private String url;
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliverable_type_id")
    private DeliverableType deliverableType;

    @Builder
    public DeliverableDocument(String title, String url, DocumentType documentType) {
        setName(title);
        this.url = url;
        this.documentType = documentType;
    }

}