package com.example.expert.entity.pay;

import com.example.expert.entity.type.PayStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayDTO {
    private Long id;
    private Long totalPrice;
    private PayStatus payStatus;
}
