package com.inc.smart.portal.document.domain.repository;

import com.inc.smart.portal.PortalApplicationTests;
import com.inc.smart.portal.document.domain.ProcessCategory;
import com.inc.smart.portal.document.domain.enums.TopMenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProcessCategoryRepositoryTest{

    @Autowired
    private ProcessCategoryRepository repository;

    @Test
    @DisplayName("엔티티 저장 및 조회 테스트")
    public void saveAndFind() {
        // given
        ProcessCategory category = new ProcessCategory("계획 수립", "icon-plan", TopMenu.PLANNING);

        // when
        ProcessCategory saved = repository.save(category);
        //then
        System.out.println(saved);
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getName()).isEqualTo("계획 수립");
        assertThat(saved.getTopMenu()).isEqualTo(TopMenu.PLANNING);

    }

}