/**
 * Created by mgumiero9 on 23/06/16.
 * This is the consumer class, composed by UC (consumer unit number) and his/her Name
 */
class Consumer {

    public int uc = 0;
    private String name = "";

    Consumer(int uc, String name) {

    }

    public int getUc() {
        return uc;
    }

    String getName() {
        return name;
    }

    public void setUc(int uc) {
        this.uc = uc;
    }

    void setName(String name) {
        this.name = name;
    }

}
