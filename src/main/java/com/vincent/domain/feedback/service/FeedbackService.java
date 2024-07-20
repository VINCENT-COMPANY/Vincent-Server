package com.vincent.domain.feedback.service;

import com.vincent.apipayload.status.ErrorStatus;
import com.vincent.domain.feedback.entity.Feedback;
import com.vincent.domain.feedback.repository.FeedbackRepository;
import com.vincent.domain.member.entity.Member;
import com.vincent.domain.member.repository.MemberRepository;
import com.vincent.exception.handler.ErrorHandler;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedbackService {

  FeedbackRepository feedbackRepository;

  MemberRepository memberRepository;

  @Transactional
  public void addFeedback(String contents, Long memberId) {

    Member member = memberRepository.findById(memberId)
        .orElseThrow(() -> new ErrorHandler(ErrorStatus.MEMBER_NOT_FOUND));

    Feedback feedback = Feedback.builder()
        .content(contents)
        .member(member)
        .build();

    feedbackRepository.save(feedback);
  }

}
