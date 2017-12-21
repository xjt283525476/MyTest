package cn.mr.test.main;

import java.util.Map;

import cn.sinieco.core.DioxinUtils;

public class Dioxin {

    /**
     * 2014-5-29 下午4:04:27 xuejiangtao添加此方法
     * @param args
     */
    public static void main(String[] args) {
        double ltrlljl = 16.6;
        double ltyqll = 50000;
        double lthjm = 26.75;
        double ltjkyqwd = 950;
        double ltckyqwd = 850;
        double ltgd = 9;

        double wbydcond = 60;
        double wbydoxygennd = 6;
        double wbydjkyqwd = 340;
        double wbydckyqwd = 220;
        double wbydccqjhl = 158;

        double bdchqhxtpsl = 45;
        double bdchqhxtbetbmj = 600;
        Map<String, Double> map = DioxinUtils.getDioxinConcentration(ltrlljl, ltyqll, lthjm, ltjkyqwd, ltckyqwd, ltgd, wbydcond, wbydoxygennd, wbydjkyqwd, wbydckyqwd, wbydccqjhl, bdchqhxtpsl, bdchqhxtbetbmj);
        System.out.println(map.toString());
        
    }
    
}
