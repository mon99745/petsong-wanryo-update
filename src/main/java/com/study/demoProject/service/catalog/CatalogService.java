package com.study.demoProject.service.catalog;

import com.study.demoProject.model.dao.catalog.CatalogDao;
import com.study.demoProject.model.dto.catalog.CatalogSummary;
import com.study.demoProject.service.item.ItemSearchForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogDao catalogDao;

    public List<CatalogSummary> getCatalog(ItemSearchForm searchForm) {
        return catalogDao.searchItem(searchForm);
    }
}
