package lin.xi.chun.circular_dependency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lin.xc
 * @date 2020/8/11
 **/
@Service
public class BService {
    @Autowired
    private AService aService;
}
