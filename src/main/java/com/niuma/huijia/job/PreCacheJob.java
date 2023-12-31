package com.niuma.huijia.job;

import com.niuma.huijia.service.UserService;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author niumazlb
 * @create 2022-08-18 21:18
 */
@Component
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    private List<Long> mainUserList = Arrays.asList(2L);

//    @Scheduled(cron = "0 00 22 * * *")
//    public void doCacheRecommendUser() {
//        RLock lock = redissonClient.getLock("langbei:preCacheJob:doCache:lock");
//        try {
//            if (lock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
//                for (Long id : mainUserList) {
//                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
//                    String redisKey = String.format("langbei:user:recommend:%s", id);
//                    redisTemplate.opsForValue().set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            if (lock.isHeldByCurrentThread()) {
//                lock.unlock();
//            }
//        }
//    }
}
