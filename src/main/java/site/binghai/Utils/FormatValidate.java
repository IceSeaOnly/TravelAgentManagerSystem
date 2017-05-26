package site.binghai.Utils;

/**
 * Created by IceSea on 2017/5/12.
 * GitHub: https://github.com/IceSeaOnly
 * 格式校验工具
 */
public class FormatValidate {
    public static boolean noEmptyOrNull(String... list){
        for (int i = 0; i < list.length; i++) {
            if(list[i] == null || list[i].length() < 1) return false;
        }
        return true;
    }
}
