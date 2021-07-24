package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.OrderDTO;
import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.Order;
import com.example.dsemoticonshop.entity.User;
import com.example.dsemoticonshop.repository.OrderRepository;
import com.example.dsemoticonshop.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllWithId(User user) {
        List<Order> orderList = orderRepository.getList(user);
        return orderList.stream().map(order -> entityToDTO(order)).collect(Collectors.toList());
    }

    @Override
    public void makeOrder(Order order) {
        User user = order.getPurchaser();
        Emoticon emoticon = order.getEmoticon_id();
        Long cnt = orderRepository.findEmoticon(user, emoticon);
        if (cnt == 0) {
            orderRepository.save(order);
        } else {
            log.info("you already have this emoticon");
        }
    }

}
