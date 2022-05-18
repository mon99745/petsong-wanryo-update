package com.study.demoProject.controller.api;

import com.study.demoProject.config.auth.PrincipalDetail;
import com.study.demoProject.model.dto.board.BoardUpdateRequestDto;
import com.study.demoProject.model.dto.board.NoticeSaveRequestDto;
import com.study.demoProject.service.board.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class NoticeApiController {
    private final NoticeService noticeService;

    /**
     * 글작성 API
     */
    @PostMapping("/api/v1/notice")
    // @PostMapping이므로 @RequestBody를 꼭붙여주어야 한다.
    // 어떤 사용자가 게시글을 작성하는지 알기 위해 @AuthenticationPrincipal 정보를 파라미터로 받는다.
    public Long save(@RequestBody NoticeSaveRequestDto noticeSaveRequestDto,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return noticeService.save(noticeSaveRequestDto, principalDetail.getUser());
    }

    /**
     * 글삭제 API
     */
    @DeleteMapping("/api/v1/notice/{id}")
    // id값을 주소에 받기 위해 @PathVariable
    public Long deleteById(@PathVariable Long id) {
        noticeService.deleteById(id);
        return id;
    }

    /**
     * 글수정 API
     */
    @PutMapping("/api/v1/notice/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto) {
        return noticeService.update(id, boardUpdateRequestDto);
    }
}
