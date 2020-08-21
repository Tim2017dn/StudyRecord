package learnStratergy;

import learnStratergy.stra.MJCouponDiscount;
import learnStratergy.stra.ZJCouponDiscount;

import java.math.BigDecimal;

public class TestStratergy {

    public static void main(String[] args) {
        ICouponDiscount s = new ZJCouponDiscount();

        Context<Double> context  = new Context(s);
        BigDecimal bigDecimal = context.discountAmount(10.3D, new BigDecimal(100));
        System.out.println(bigDecimal);


    }
}
