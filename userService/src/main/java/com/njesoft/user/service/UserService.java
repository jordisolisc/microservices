package com.njesoft.user.service;

import com.njesoft.user.VO.Department;
import com.njesoft.user.VO.ResponseTemplateVO;
import com.njesoft.user.entity.User;
import com.njesoft.user.respositry.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departaments/" + user.getDepartamentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

}
