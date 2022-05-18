package com.study.demoProject.service.item;

import com.study.demoProject.controller.Sorter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemSearchForm {
    private String name;
    private Sorter sorter;
    private Long categoryId;
}
