package com.inc.smart.portal.document.domain.repository;

import com.inc.smart.portal.document.domain.entity.ProcessCategory;
import com.inc.smart.portal.document.domain.enums.TopMenu;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public class ProcessCategoryRepositoryTest {

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

    @Test
    @DisplayName("Top menu 로 조회하기")
    public void test_findByTopMenu(){
        // given
        ProcessCategory category1 = new ProcessCategory("계획 수립", "icon-plan", TopMenu.PLANNING);
        ProcessCategory category2 = new ProcessCategory("완료 보고", "icon-plan", TopMenu.PLANNING);
        // when
        repository.save(category1);
        repository.save(category2);
        //then
        List<ProcessCategory> result = repository.findByTopMenu(TopMenu.PLANNING);
        assertThat(result).hasSize(2)
                .extracting("name")
                .containsExactly("계획 수립", "완료 보고");
    }

}