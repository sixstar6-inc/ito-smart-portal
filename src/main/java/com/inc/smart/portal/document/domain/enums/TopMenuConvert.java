package com.inc.smart.portal.document.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TopMenuConvert implements AttributeConverter<TopMenu, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TopMenu topMenu) {
        return topMenu.getCode();
    }

    @Override
    public TopMenu convertToEntityAttribute(Integer code) {
        return TopMenu.findByCode(code);
    }
}