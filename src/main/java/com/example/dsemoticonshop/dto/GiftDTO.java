package com.example.dsemoticonshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiftDTO {

    private OrderDTO order_id;

    private UserDTO user_id;
}
