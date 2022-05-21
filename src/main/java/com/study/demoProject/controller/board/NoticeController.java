package com.study.demoProject.controller.board;

import com.study.demoProject.service.board.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class NoticeController {
    private final NoticeService noticeService;

    /**
     * 공지사항 페이지
     */
    @GetMapping("/auth/board/notice")
    public String notice() {
        return "board/notice/Notice";
    }

    /**
     * 글작성 페이지
     */
    @GetMapping("/board/notice/save")
    public String save() {
        return "board/notice/notice-save";
    }

    /**
     * 글상세 페이지
     */
    // 주소 뒤에 {id} 이렇게 id를 받을 때는 @PathVariable을 사용하면 주소의 id로 받습니다.
    @GetMapping("/board/notice/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("board", noticeService.detail(id));
        noticeService.updateCount(id);
        return "board/notice/notice-detail";
    }

    /**
     * 글 수정 페이지
     */
    @GetMapping("/board/notice/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("board", noticeService.detail(id));
        return "board/notice/notice-update";
    }
}
