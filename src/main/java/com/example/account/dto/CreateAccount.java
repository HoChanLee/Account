package com.example.account.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class CreateAccount {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class request{
        @NotNull //벨리데이션
        @Min(1) //벨리데이션
        private Long userId;

        @NotNull //벨리데이션
        @Min(0) //벨리데이션
        private Long initialBalance;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private Long userId;
        private Long accountNumber;
        private LocalDateTime registeredAt;

        public static Response from(AccountDto accountDto){
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(Long.valueOf(accountDto.getAccountNumber()))
                    .registeredAt(accountDto.getRegisteredAt())
                    .build();
        }
    }
}
