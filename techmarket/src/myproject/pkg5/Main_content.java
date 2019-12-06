package myproject.pkg5;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Main_content extends JFrame{
    private ArrayList<Good> goods = null;
    private ArrayList<String> Basket = null;
    private ArrayList<Integer> BasketCount = null;
    private MenuSignIn signIn = null;
    private MenuAdmin admin = null;
    private AdminAdd admin_add = null;
    private Good_get_list goodlist = null;
    private AddCount add_count = null;
    private GoodRemove rem_good = null;
    private Income income = null;
    private Admin_or_Client admin_client = null;
    private MenuClient client = null;
    private GoodList glist = null;
    private AddToBasket add_toBasket = null;
    private LookingFor_byModel look_for = null;
    
    
    public Main_content(String s){
        super(s);
        goods = new ArrayList<>();
        Basket = new ArrayList<>();
        BasketCount = new ArrayList<>();
        signIn = new MenuSignIn(this);
        admin = new MenuAdmin(this);
        admin_add = new AdminAdd(this);
        goodlist = new Good_get_list(this);
        add_count = new AddCount(this);
        rem_good = new GoodRemove(this);
        income = new Income(this);
        admin_client = new Admin_or_Client(this);
        client = new MenuClient(this);
        glist = new GoodList(this);
        add_toBasket = new AddToBasket(this, Basket, BasketCount);
        look_for = new LookingFor_byModel(this);

        add(signIn);add(admin);add(admin_add);add(goodlist);add(add_count);add(rem_good);
        add(income);add(admin_client);add(client);add(glist);add(add_toBasket);add(look_for);
        setSize(600,450);
        
        ImageIcon img = new ImageIcon("C:\\Users\\Администратор\\Desktop\\tec.jpg");
        JLabel l1 = new JLabel("", img, JLabel.CENTER);
        l1.setBounds(0, 0, 600, 450);
        add(l1);
        
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public LookingFor_byModel LookFor(){
        return look_for;
    }
    
    public AddToBasket addToBasket(){
        return add_toBasket;
    }
    
    public GoodList goodList(){
        return glist;
    }
    
    public MenuClient menuClient(){
        return client;
    }
    
    public Admin_or_Client getAdm_or_Client(){
        return admin_client;
    }
    
    public Income getIncome(){
        return income;
    }
    
    public GoodRemove RemGood(){
        return rem_good;
    }
    
    public AddCount getAddCount(){
        return add_count;
    }
    
    public MenuAdmin getAdminMenu(){
        return admin;
    }
    
    public MenuSignIn getSignIn(){
        return signIn;
    }
    
    public AdminAdd getAdd(){
        return admin_add;
    }
    
    public Good_get_list getGoodList(){
        return goodlist;
    }
    
    public Good getGood(int i){
        return goods.get(i);
    }
    
    public void addGood(Good g){
        goods.add(g);
    }
    
    public void addGood(int i, Good g){
        goods.add(i, g);
    }
    
    public void removeGood(int i){
        goods.remove(i);
    }
    
    public int getGoodSize(){
        return goods.size();
    }
    
    public ArrayList<String> getBasket(){
        return Basket;
    }
    public ArrayList<Integer> getBasketCount(){
        return BasketCount;
    }
    
    public void checkBasket(){
        if(Basket.size()==0){
            JOptionPane.showMessageDialog(Main_content.this, "YOUR BASKET IS EMPTY");
        }
        else {
            String basket = "There are "+ Basket.size()+1 + " goods in your Basket\n";
            int s = 0;
            for (int i = 0; i < Basket.size(); i++) {
                basket += Basket.get(i) + " " + BasketCount.get(i) + " " + getGood(i).getPrice() + ":" + (getGood(i).getPrice() * BasketCount.get(i)) + "\n";
                s += (getGood(i).getPrice() * BasketCount.get(i));
            }
            basket = basket + " All price of Basket: " + s;
            JOptionPane.showMessageDialog(Main_content.this, basket);
        }
    }
    
    public void switchFrame(Container x, Container y){
        y.setVisible(false);
        x.setVisible(true);
    }

}
