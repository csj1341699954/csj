
public class Book {



    private  static  Book  book;

    private  static  Book  book1;

    private  static  String getName(){
        return "aaa";
    }
    static {
        book =new Book();
        book1 =new Book();
        String getName=getName();
        System.out.println(getName);
    }

    private     Book(){
     System.out.println("-=-=-=-=-=-=-=-=-=-");
    }

    public  static  Book  book(){
        return  book;
    }

    private  String  goodsName;



    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
