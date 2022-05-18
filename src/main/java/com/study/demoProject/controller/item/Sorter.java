package com.study.demoProject.controller.item;

import lombok.Getter;

@Getter
public enum Sorter {
    PRICE("가격순"), LATEST("최신순");

    private String sorter;

    Sorter(String sorter) {
        this.sorter = sorter;
    }
}
