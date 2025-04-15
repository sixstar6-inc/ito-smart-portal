package com.inc.smart.portal.document.domain;

import com.inc.smart.portal.document.common.entity.NamedEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 2 Depth 에 해당하는 산출물 유형을 나타내는 클래스입니다.
 * 하위에 지침서, 산출물, 절차서를 포함하고 있고 각각은
 * 여러 개의 산출물 문서(DeliverableDocument) 를 가집니다.
 */
@Getter
@NoArgsConstructor
@Table(name = "TB_DELIVERABLE_TYPE")
@Entity
public class DeliverableType extends NamedEntity {

    @NotNull
    @Column(name = "process_category_id", nullable = false)
    private Long processCategoryId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "deliverable_type_id") // 외래 키 매핑
    private List<DeliverableDocument> documents = new ArrayList<>();

    @Builder
    public DeliverableType(String title, Long processCategoryId) {
        setName(title);
        this.processCategoryId = processCategoryId;
    }

    public void addDocument(DeliverableDocument document) {
        document.setDeliverableType(this);
        this.documents.add(document);
    }
}
