package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.vo.Department;
import com.dailycodebuffer.user.vo.ResponseTemplateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        log.info("Saving user {0}", user);
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = null;
        User user = userRepository.findById(userId).orElse(null);
        if( user != null ) {
            log.info("User {} is found. Calling department service.", user);
            Department department = restTemplate.getForObject(MessageFormat.format("http://DEPARTMENT-SERVICE/departments/{0}", user.getDepartmentId()), Department.class);
            log.info("Department {0} is found.", department);
            vo = new ResponseTemplateVO(user, department);
        }else{
            log.info("No user is found for {}", userId);
        }
        return vo;
    }
}
