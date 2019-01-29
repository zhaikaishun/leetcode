package me.kaishun.平时自己想的一些算法.小区切换序列;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String[] strs = {
                "A_B_3",
                "A_C_1",
                "B_C_3",
                "B_D_1",
                "B_E_1",
                "C_D_3",
                "C_F_1",
                "D_E_3",
                "D_F_1",
                "D_G_1",
                "E_G_1",
                "E_F_3",
                "F_G_3",
                "F_H_1",
                "G_H_3",
                //这3个是干扰项
                "E_P_6",
                "P_B_3",
                "G_T_100"
        };
        Solution solution = new Solution();
        boolean findAtoH = solution.findEciSwitch(strs, "A", "H");
        if(findAtoH){
            for (String s : solution.result) {
                System.out.print(s+" ");
            }
        }else {
            System.out.println("找不到A到H");
        }

    }

    public boolean findEciSwitch(String[] strs, String eciStart,String eciEnd) {
        HashMap<String, ArrayList<Model>> allMaps = new HashMap<>();
        // 读文件
        for (String line : strs) {
            String[] split = line.split("_");
            String eciA = split[0];
            String eciB = split[1];
            int count = Integer.parseInt(split[2]);
            if(allMaps.containsKey(eciA)){
                allMaps.get(eciA).add(new Model(eciB,count));
            }else {
                ArrayList<Model> models = new ArrayList<>();
                models.add(new Model(eciB,count));
                allMaps.put(eciA,models);
            }
        }

        //list中按照count按照从大到小排序
        for (Map.Entry<String, ArrayList<Model>> listEntry : allMaps.entrySet()) {
            Collections.sort(listEntry.getValue());
        }
        //深度搜索，次数优先，搜索不到进行回溯，次数依次降低
        //优化建议，建议可以使用并查集先判断能否到达H，并查集时间复杂度0(n)

        findEnd(allMaps,eciStart,eciEnd);
        return jumpOut;
    }



    public ArrayList<String> result = new ArrayList<>();
    //判断是否循环
    public HashSet<String> sets = new HashSet<>();
    //跳出递归标识
    public boolean jumpOut;

    public void findEnd(HashMap<String, ArrayList<Model>> allMaps, String eciStart, String eciEnd){
        result.add(eciStart);
        sets.add(eciStart);
        if(eciStart.equals(eciEnd)){
            jumpOut=true;
            return;
        }

        ArrayList<Model> models = allMaps.get(eciStart);
        if(models==null){
            return;
        }
        for (int i = 0; i < models.size(); i++) {
            Model model = models.get(i);
            ////如果进入了循环，直接continue
            if(sets.contains(model.eci)){
                continue;
            }
            findEnd(allMaps,model.eci,eciEnd);
            //如果找到了最后的H，就跳出循环
            if(jumpOut){
                return;
            }
            sets.remove(result.get(result.size()-1));
            result.remove(result.size()-1);
        }
    }
}
