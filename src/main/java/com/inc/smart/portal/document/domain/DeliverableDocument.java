package com.inc.smart.portal.document.domain;

import com.inc.smart.portal.document.common.entity.NamedEntity;
import jakarta.persistence.Entity;

/**
 * 3Depth 에 해당하는 실제 산출물 문서를 나타내는 클래스입니다.
 * 예: 요구사항 명세서 문서, 제안요청서 초안등
 */
@Entity
public class DeliverableDocument extends NamedEntity {
}