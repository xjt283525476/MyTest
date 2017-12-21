package cn.mr.test.main;

import java.util.List;

public class MyTreeNote {
    
    private String noteName;
    
    private String path;
    
    private int level;
    
    private List<MyTreeNote> children;
    
    public MyTreeNote (String noteName, String path, int level) {
        this.noteName = noteName;
        this.path = path;
        this.level = level;
    }
    
    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<MyTreeNote> getChildren() {
        return children;
    }

    public void setChildren(List<MyTreeNote> children) {
        this.children = children;
    }
    
    @Override
    public String toString() {
        String result = this.noteName;
        if (this.children != null && this.children.size() > 0) {
            for (MyTreeNote childNode : this.children) {
                String sep = "";
                for(int i = 0; i < this.level; i++) {
                    sep += "--";
                }
                result += "\r" + sep + childNode.toString();
            }
        }
        return result;
    }
    
}
