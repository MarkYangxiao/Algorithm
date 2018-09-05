package IO;

import java.io.*;

/**
 * Created by Yangxiao on 2018/8/25.
 * desc:
 */
public class SerialDemo {
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    //序列化
    FileOutputStream fos = new FileOutputStream("object.out");
    ObjectOutputStream oos = new ObjectOutputStream(fos);
    User user1 = new User("yangxiao", "123456", "male");
    oos.writeObject(user1);
    oos.flush();
    oos.close();

    //反序列化
    FileInputStream fis = new FileInputStream("object.out");
    ObjectInputStream ois = new ObjectInputStream(fis);
    User user2 = (User) ois.readObject();
    System.out.println(user2.userName + " " + user2.getPassword() + " " + user2.getSex());

  }

  public static class User implements Serializable {

    public String getUserName() {
      return userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getSex() {
      return sex;
    }

    public void setSex(String sex) {
      this.sex = sex;
    }

    private String userName;
    private String password;
    private String sex;

    public User(String userName, String password, String sex) {
      this.userName = userName;
      this.password = password;
      this.sex = sex;
    }
  }
}
