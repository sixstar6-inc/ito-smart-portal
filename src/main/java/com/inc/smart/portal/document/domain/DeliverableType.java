package com.inc.smart.portal.document.domain;

import com.inc.smart.portal.document.common.entity.NamedEntity;
import jakarta.persistence.Entity;

/**
 * 2 Depth 에 해당하는 산출물 유형을 나타내는 클래스입니다.
 * 하위에 지침서, 산출물, 절차서를 포함하고 있고 각각은
 * 여러 개의 산출물 문서(DeliverableDocument) 를 가집니다.
 */
@Entity
public class DeliverableType extends NamedEntity {
}
