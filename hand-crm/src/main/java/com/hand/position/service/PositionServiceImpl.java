package com.hand.position.service;

import com.hand.position.access.dao.PositionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionDao positionDao;
}
