package com.example.dsemoticonshop.service.implement;

import com.example.dsemoticonshop.dto.OrderDTO;
import com.example.dsemoticonshop.entity.Order;
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
    public List<OrderDTO> getAllWithId(int id) {
        List<Order> orderList = orderRepository.getList(id);
        return orderList.stream().map(order -> entityToDTO(order)).collect(Collectors.toList());
    }
}
