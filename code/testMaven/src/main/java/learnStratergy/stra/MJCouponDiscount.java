package learnStratergy.stra;

import learnStratergy.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {


    @Override
    public BigDecimal discountAmouint(Map<String, String> couponInfo, BigDecimal skuPrice) {
       String x = couponInfo.get("x");
       String o = couponInfo.get("n");
       if(skuPrice.compareTo(new BigDecimal(x))<0 ) {return skuPrice;}

       BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(o));
       return discountAmount;

    }
}
