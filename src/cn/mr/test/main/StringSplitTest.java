package cn.mr.test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StringSplitTest {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();
        strs.add("一级1/二级11/三级111");                
        strs.add("一级2/二级21/三级211");
        strs.add("一级1/二级11/三级112");
        strs.add("一级1/二级12/三级121");
        strs.add("一级1/二级11/三级111/四级1111");
        strs.add("一级2/二级22/三级221");
        strs.add("一级1/二级11/三级113");
        strs.add("一级1/二级12/三级122");
        
        //存放父路径及父节点，方便快速判断父节点是否存在、找到父节点
        Map<String, MyTreeNote> map = new HashMap<String, MyTreeNote>();
        int maxLevel = 1;
        List<String[]> lists = new ArrayList<String[]>();
        List<MyTreeNote> results = new ArrayList<MyTreeNote>();
        for (String str : strs) {
            String[] split = str.split("/");
            lists.add(split);
            int length = split.length;
            if (maxLevel < length) {
                maxLevel = length;
            }
        }
        for(int i = 0; i < maxLevel; i++) {
            for (String[] arrays : lists) {
                if (arrays.length <= i) {
                    continue;
                }
                String nname = arrays[i];
                if (i == 0) {
                    if (map.get(nname+"/") == null) {
                        MyTreeNote treeNote = new MyTreeNote(nname, "", i+1);
                        results.add(treeNote);
                        map.put(nname+"/", treeNote);
                        map.put(nname, null);
                    }
                } else {
                    String parentPath = "";
                    //构建父路径，快速查到父节点
                    for (int j = 0 ; j < i ; j++) {
                        parentPath = parentPath + arrays[j] + "/";
                    }
                    //判断节点是否存在，如果存在则跳过
                    if (map.get(parentPath+arrays[i]+"/") != null ) {
                        continue;
                    }
                    if (map.get(parentPath) != null) {
                        MyTreeNote pTreeNote = map.get(parentPath);
                        MyTreeNote treeNote = new MyTreeNote(nname, "", i+1);
                        map.put(nname, null);
                        List<MyTreeNote> childrens = pTreeNote.getChildren();
                        if (childrens == null) {
                            childrens = new ArrayList<MyTreeNote>();
                        }
                        childrens.add(treeNote);
                        pTreeNote.setChildren(childrens);
                        map.put(parentPath+arrays[i]+"/", treeNote);
                    }
                }
            }
        }
        for (MyTreeNote myTreeNote : results) {
            System.out.println(myTreeNote.toString());
        }
    }
}
