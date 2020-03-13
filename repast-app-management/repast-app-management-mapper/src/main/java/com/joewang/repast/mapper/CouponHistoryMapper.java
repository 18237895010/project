package com.joewang.repast.mapper;

import com.joewang.repast.model.CouponHistory;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CouponHistoryMapper extends Mapper<CouponHistory> {
    List<CouponHistory> selectMemberCoupon(Long memberid);
}