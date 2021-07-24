package com.example.dsemoticonshop.service.interfaces;

import com.example.dsemoticonshop.dto.OrderDTO;
import com.example.dsemoticonshop.entity.Order;
import com.example.dsemoticonshop.entity.User;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllWithId(User user);
    void makeOrder(Order order);

    default Order dtoToEntity(OrderDTO orderDTO) {
        Order order = Order.builder()
                .order_id(orderDTO.getOrder_id())
                .order_date(orderDTO.getOrder_date())
                .method(orderDTO.getMethod())
                .order_price(orderDTO.getOrder_price())
                .emoticon_id(orderDTO.getEmoticon_id())
                .purchaser(orderDTO.getPurchaser())
                .build();
        return order;
    }

    default OrderDTO entityToDTO(Order order) {
        OrderDTO orderDTO = OrderDTO.builder()
                .order_id(order.getOrder_id())
                .order_date(order.getOrder_date())
                .method(order.getMethod())
                .order_price(order.getOrder_price())
                .emoticon_id(order.getEmoticon_id())
                .purchaser(order.getPurchaser())
                .build();
        return orderDTO;
    }
}
