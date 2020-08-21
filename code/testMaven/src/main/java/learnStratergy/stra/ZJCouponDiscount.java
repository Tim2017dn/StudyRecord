package learnStratergy.stra;

import learnStratergy.ICouponDiscount;

import java.math.BigDecimal;

public class ZJCouponDiscount implements ICouponDiscount<Double> {


    @Override
    public BigDecimal discountAmouint(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));

        if(discountAmount.compareTo(BigDecimal.ZERO)<1){return BigDecimal.ZERO;}
        return discountAmount;
    }
}
