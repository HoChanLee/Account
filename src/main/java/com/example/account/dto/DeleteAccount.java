package com.example.account.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class DeleteAccount {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request{
        @NotNull //벨리데이션
        @Min(1) //벨리데이션
        private Long userId;

        @NotBlank //벨리데이션
        @Size(min = 10, max = 10) //벨리데이션
        private String accountNumber;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long userId;
        private Long accountNumber;
        private LocalDateTime unRegisteredAt;

        public static Response from(AccountDto accountDto){
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(Long.valueOf(accountDto.getAccountNumber()))
                    .unRegisteredAt(accountDto.getUnRegisteredAt())
                    .build();
        }
    }
}
