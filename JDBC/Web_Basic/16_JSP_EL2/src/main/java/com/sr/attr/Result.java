package com.sr.attr;

//ÀÚ¹Ù ºó
public class Result {

private int price;
private int money;
private int exchange;
private String say;

public Result() {
   // TODO Auto-generated constructor stub
}

public Result(int price, int money, int exchange, String say) {
   super();
   this.price = price;
   this.money = money;
   this.exchange = exchange;
   this.say = say;
}

public int getPrice() {
   return price;
}

public void setPrice(int price) {
   this.price = price;
}

public int getMoney() {
   return money;
}

public void setMoney(int money) {
   this.money = money;
}

public int getExchange() {
   return exchange;
}

public void setExchange(int exchange) {
   this.exchange = exchange;
}

public String getSay() {
   return say;
}

public void setSay(String say) {
   this.say = say;
}

}
