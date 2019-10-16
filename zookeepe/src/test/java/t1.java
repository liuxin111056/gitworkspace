import org.junit.Test;

/**
 * liuxin
 * 2019/8/29 0029
 */
public class t1 {

    public static String camelToSplitName(String camelName, String split) {
        StringBuilder buf = null;
        for (int i = 0; i < camelName.length(); i++) {
            char ch = camelName.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                if (buf == null) {
                    buf = new StringBuilder();
                    if (i > 0) {
                        buf.append(camelName.substring(0, i));
                    }
                }
                if (i > 0) {
                    buf.append(split);
                }
                buf.append(Character.toLowerCase(ch));
            } else if (buf != null) {
                buf.append(ch);
            }
        }
        return buf == null ? camelName : buf.toString();
    }
    @Test
    public void t11(){
        System.out.println(camelToSplitName("SerViCe","-"));
    }
}
