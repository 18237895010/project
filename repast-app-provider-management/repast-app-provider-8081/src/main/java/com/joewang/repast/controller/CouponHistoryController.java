package com.joewang.repast.controller;

import com.github.pagehelper.PageInfo;
import com.joewang.repast.model.Coupon;
import com.joewang.repast.model.CouponHistory;
import com.joewang.repast.page.PageInfos;
import com.joewang.repast.service.CouponHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @description:
 *      用户优惠券相关的Provider层Controller类
 * @author: Joe Wang
 * @date: 2020-03-13
 */
@RestController
@EnableScheduling
public class CouponHistoryController {
    @Autowired
    private CouponHistoryService service;

    /**
     * @desc:
     *      根据用户id查询用户所有优惠券
     * @author: Joe Wang 
     * @date: 2020/3/14 
     * @param: [memberid]
     * @return: java.util.List<java.util.HashMap> 
     */
    @PostMapping("/selectMyCoupon")
    public List<HashMap> selectMyCoupon(@RequestBody Long memberid){
        return service.selectMyCoupon(memberid);
    }

    /**
     * @desc: 根据用户id查询用户所有优惠券 分页查询
     * @author: Joe Wang
     * @date: 2020/3/14
     * @param: [pageInfos]
     * @return: com.github.pagehelper.PageInfo<java.util.List<java.util.HashMap>>
     */
    @PostMapping("/selectMyCouponPage")
    PageInfo<HashMap> selectMyCouponPage(@RequestBody PageInfos<Long> pageInfos){
        return service.selectMyCouponPage(pageInfos);
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void updateMemberCouponState(){
        Integer updateResult = service.updateMemberCouponState();
        System.out.println("成功更新" + updateResult + "条优惠券信息");
    }

    /**
     * @desc: 根据用户id查询用户可领通用优惠券
     * @author: Joe Wang
     * @date: 2020/3/14
     * @param: [memberid]
     * @return: java.util.List<com.joewang.repast.model.Coupon>
     */
    @PostMapping("/selectConponCouldGetById")
    public List<Coupon> selectConponCouldGetById(@RequestBody Long memberid){
        return service.selectConponCouldGet(memberid);
    }

    /**
     * @desc: 根据用户id查询用户可领通用优惠券并实现分页
     * @author: Joe Wang
     * @date: 2020/3/14
     * @param: [pageInfos]
     * @return: com.github.pagehelper.PageInfo<com.joewang.repast.model.Coupon>
     */
    @PostMapping("/selectConponCouldGetByIdPage")
    public PageInfo<Coupon> selectConponCouldGetByIdPage(@RequestBody PageInfos<Long> pageInfos){
        return service.selectConponCouldGetPage(pageInfos);
    }
}
