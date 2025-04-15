package com.inc.smart.portal.document.domain;

import com.inc.smart.portal.document.common.entity.NamedEntity;
import com.inc.smart.portal.document.domain.enums.TopMenu;
import com.inc.smart.portal.document.domain.enums.TopMenuConvert;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * [1 Depth]
 * Side menu 에 해당하는 프로세스 단계를 나타내는 클래스입니다.
 * 예) "사전단계", "프로젝트 발의"
 * 각 카테고리는 여러 개의 산출물 유형(DeliverableType)을 포함할 수 있습니다.
 */
@ToString
@Getter
@NoArgsConstructor
@Table(name = "TB_PROCESS_CATEGORY")
@Entity
public class ProcessCategory extends NamedEntity {

    private String iconClass;

    @Convert(converter = TopMenuConvert.class)
    private TopMenu topMenu;

    public ProcessCategory(String name, String iconClass, TopMenu topMenu) {
        setName(name);
        this.iconClass = iconClass;
        this.topMenu = topMenu;
    }

}
