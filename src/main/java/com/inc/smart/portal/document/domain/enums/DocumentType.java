package com.inc.smart.portal.document.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Deliverable Document 의 문서 유형 정의
 */
@Getter
public enum DocumentType  {
    // 지침서
    GUIDE("지침서"),
    // 절차서
    PROCEDURE("절차서"),
    // 산출물
    OUTPUT("산출물");

    private final String description;

    // 생성자
    DocumentType(String description) {
        this.description = description;
    }

    //return DocumentType from name
    public static DocumentType from(String name) {
        return Arrays.stream(DocumentType.values())
                .filter(documentType -> documentType.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching document type for name: " + name));
    }

    public static Map<String, String> toMap() {
        return Arrays.stream(DocumentType.values())
                .collect(Collectors.toMap(DocumentType::name, DocumentType::getDescription));
    }

    public boolean equalsType(DocumentType other) {
        return this == other;
    }
}
