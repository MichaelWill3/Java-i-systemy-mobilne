public class main {
    public static void main(String[] args){

        FulfillmentCenterContainer FFCC = new FulfillmentCenterContainer();

        FFCC.addCenter("a", 2000.000004);
        FFCC.addCenter("n", 30);
        FFCC.addCenter("P", 30);

        Item item1 = new Item("krowa", ItemCondition.USED, 580 );
        Item item2 = new Item("rak", ItemCondition.REFURBISHED, 2.3 );
        Item item3 = new Item("cukierek", ItemCondition.USED, 0.01 );
        Item item4 = new Item("ksiazka", ItemCondition.NEW, 2.1 );

        System.out.println(FFCC.findEmpty());
        FFCC.removeCenter("n");
        System.out.println(FFCC.findEmpty());
        FFCC.magazyny.get("a").addProduct(item1);
        FFCC.magazyny.get("a").addProduct(item1);
        FFCC.magazyny.get("a").addProduct(item3);
        FFCC.magazyny.get("a").addProduct(item3);
        FFCC.magazyny.get("a").addProduct(item3);
        FFCC.magazyny.get("a").addProduct(item2);
        FFCC.magazyny.get("a").addProduct(item2);
        FFCC.magazyny.get("a").addProduct(item4);

        FFCC.magazyny.get("a").summary();
        FFCC.summary();

        System.out.println(FFCC.magazyny.get("a").max());

        System.out.println(FFCC.magazyny.get("a").countByCondition(ItemCondition.USED));
        System.out.println(FFCC.magazyny.get("a").search("rak"));
        System.out.println(FFCC.magazyny.get("a").searchPartial("a"));
        System.out.println(FFCC.magazyny.get("a").sortByName());
        System.out.println(FFCC.magazyny.get("a").sortByAmount());//nope

    }
}
