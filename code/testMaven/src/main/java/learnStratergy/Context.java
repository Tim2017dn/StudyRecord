package learnStratergy;

import java.math.BigDecimal;

public class Context<T> {
    private ICouponDiscount<T> couponDiscount;


    public Context(ICouponDiscount<T> coupon){
        this.couponDiscount = coupon;
    }

    public BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice){
        return couponDiscount.discountAmouint(couponInfo,skuPrice);
    }

}
