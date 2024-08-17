package com.vincent.domain.socket.controller;


import com.vincent.apipayload.ApiResponse;
import com.vincent.config.security.principal.PrincipalDetails;
import com.vincent.domain.bookmark.service.BookmarkService;
import com.vincent.domain.building.controller.dto.BuildingResponseDto;
import com.vincent.domain.building.converter.BuildingConverter;
import com.vincent.domain.building.entity.Floor;
import com.vincent.domain.building.entity.Space;
import com.vincent.domain.socket.controller.dto.SocketResponseDto;
import com.vincent.domain.socket.converter.SocketConverter;
import com.vincent.domain.socket.entity.Socket;
import com.vincent.domain.socket.service.SocketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/v1")
public class SocketController {

    private final SocketService socketService;
    private final BookmarkService bookmarkService;

    @GetMapping("/socket/{socketId}")
    public ApiResponse<SocketResponseDto.SocketInfo> socketInfo(@PathVariable("socketId") Long socketId,
        Authentication authentication) {

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        Long memberId = principalDetails.getMemberId();
        Boolean isBookmarkExist = bookmarkService.getBookmarkExist(socketId, memberId);
        Socket socketInfo = socketService.getSocketInfo(socketId);
        return ApiResponse.onSuccess(SocketConverter.toSocketInfoResponse(socketInfo, isBookmarkExist));
    }


    @GetMapping("/socket")
    public ApiResponse<SocketResponseDto.SocketLocationList> getSocketLocationList(
        @RequestParam("buildingId") Long buildingId,
        @RequestParam("level") Integer level) {
        return  ApiResponse.onSuccess((
            SocketConverter.toSocketLocationList(socketService.getSocketList(buildingId, level))));


    }



}
