package com.autowave.controller.impl;

import com.autowave.base.controller.impl.AbstractCrudController;
import com.autowave.controller.ISubscriptionController;
import com.autowave.dto.list.SubscriptionListDTO;
import com.autowave.dto.request.SubscriptionRequestDTO;
import com.autowave.dto.response.SubscriptionResponseDTO;
import com.autowave.entities.Subscription;
import com.autowave.mapper.SubscriptionMapper;
import com.autowave.service.impl.SubscriptionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${api.version}/subscription")
public class SubscriptionController extends AbstractCrudController<SubscriptionRequestDTO, SubscriptionResponseDTO, SubscriptionListDTO, Subscription, SubscriptionService, SubscriptionMapper, Long>
        implements ISubscriptionController {
}
