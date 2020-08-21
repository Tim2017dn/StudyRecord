package learnStratergy;

import java.math.BigDecimal;

public interface ICouponDiscount<T> {
    BigDecimal discountAmouint(T couponInfo,BigDecimal skuPrice);

}
