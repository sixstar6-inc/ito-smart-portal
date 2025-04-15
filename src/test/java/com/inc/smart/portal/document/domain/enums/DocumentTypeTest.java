package com.inc.smart.portal.document.domain.enums;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DocumentTypeTest {

    @Test
    public void from_existingName_returnCorrectDocumentType(){
        assertAll(
                () -> assertThat(DocumentType.GUIDE).isEqualTo(DocumentType.from("GUIDE")),
                () -> assertThat(DocumentType.PROCEDURE).isEqualTo(DocumentType.from("PROCEDURE")),
                () -> assertThat(DocumentType.OUTPUT).isEqualTo(DocumentType.from("OUTPUT"))
        );
    }

    @Test
    public void from_nonExistingName_throwIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> DocumentType.from("INVALID"));
    }

    @Test
    public void test_toMap(){
        Map<String, String> result = DocumentType.toMap();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void test_getDescription(){
        assertThat(DocumentType.OUTPUT.getDescription()).isEqualTo("산출물");
    }

    @Test
    public void test_equalsType(){
        assertThat(DocumentType.OUTPUT.equalsType(DocumentType.OUTPUT)).isTrue();
    }
}