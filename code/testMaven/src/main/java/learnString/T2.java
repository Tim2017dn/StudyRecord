package learnString;

import org.apache.commons.lang3.StringUtils;

public class T2 {

    public static void main(String[] args) {

        String string = "初始值";
        StringBuffer stringBuffer = new StringBuffer("初始值");
        StringBuilder stringBuilder = new StringBuilder("初始值");
        System.out.println("string:"+string.hashCode());
        System.out.println("stringBuffer:"+stringBuffer.hashCode());
        System.out.println("stringBuilder:"+stringBuilder.hashCode());
        string = string+"更新了";
        stringBuffer = stringBuffer.append("更新了");
        stringBuilder = stringBuilder.append("更新了");
        System.out.println("***********************************");
        System.out.println("string:"+string.hashCode());
        System.out.println("stringBuffer:"+stringBuffer.hashCode());
        System.out.println("stringBuilder:"+stringBuilder.hashCode());

    }
}
