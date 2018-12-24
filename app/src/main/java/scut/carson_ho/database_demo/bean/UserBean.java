package scut.carson_ho.database_demo.bean;

/**
 * Created by lixiang
 * on 2018/12/24
 */
public class UserBean {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;
}
