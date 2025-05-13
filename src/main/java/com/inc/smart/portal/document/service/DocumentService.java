package com.inc.smart.portal.document.service;

import com.inc.smart.portal.document.domain.repository.ProcessCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DocumentService {

    private final ProcessCategoryRepository processCategoryRepository;

}