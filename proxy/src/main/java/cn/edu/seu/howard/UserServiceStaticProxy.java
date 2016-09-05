package cn.edu.seu.howard;

public class UserServiceStaticProxy implements UserService{

    private UserServiceImpl target;

    public UserServiceStaticProxy(UserServiceImpl target) {
        this.target = target;
    }

    public void add() {
        System.out.println("-------before---------");
        target.add();
        System.out.println("-------after---------");
    }
}
