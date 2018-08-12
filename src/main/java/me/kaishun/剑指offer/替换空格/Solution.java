package me.kaishun.剑指offer.替换空格;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("We Are Happy");
        System.out.println(myReplaceSpace(stringBuffer));
    }
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
        StringBuffer newStr=new StringBuffer();
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)==' '){
                newStr.append('%').append('2').append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return  newStr.toString();
    }

    /**'
     * 19nm
     * @param str
     * @return
     */
    public static String myReplaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        char[] chars = str.toString().toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            String theChar = String.valueOf(chars[i]);
            if(theChar.equals(" ")){
                sb.append("%20");
            }else{
                sb.append(theChar);
            }
        }
        return  sb.toString();
    }

}
