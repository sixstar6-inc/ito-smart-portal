package com.inc.smart.portal.document.domain.enums;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TopMenuTest {

    @Test
    public void test_from_topMenuCodeList(){

        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = TopMenu.topMenuCodeList();
        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void test_from_topMenuList(){
        List<String> result = TopMenu.topMenuList();
        assertThat(result).hasSize(4)
                .containsExactly("프로젝트 계획","프로젝트 수행","운영","유지보수");
    }

    @Test
    public void test_findByCode(){
        assertEquals(TopMenu.PLANNING, TopMenu.findByCode(1));
        assertEquals(TopMenu.PROGRESS, TopMenu.findByCode(2));
        assertEquals(TopMenu.OPERATION, TopMenu.findByCode(3));
        assertEquals(TopMenu.MAINTAIN, TopMenu.findByCode(4));
    }

}