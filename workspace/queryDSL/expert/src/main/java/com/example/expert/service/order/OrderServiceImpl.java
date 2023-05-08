package com.example.expert.service.order;

import com.example.expert.entity.order.Order;
import com.example.expert.entity.order.OrderDTO;
import com.example.expert.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Qualifier("order") @Primary
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public OrderDTO getOrdersWithMember(Long id) {
        Optional<Order> order = orderRepository.findMemberByOrderId(id);
        return toOrderDTO(order.get());
    }
}
