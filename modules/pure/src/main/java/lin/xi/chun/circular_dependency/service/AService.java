package lin.xi.chun.circular_dependency.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lin.xc
 * @date 2020/8/11
 **/
@Service
public class AService {
    @Autowired
    private BService bService;

    private void test(){

    }
}
