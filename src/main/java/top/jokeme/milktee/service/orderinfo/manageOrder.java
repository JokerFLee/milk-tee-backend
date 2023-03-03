package top.jokeme.milktee.service.orderinfo;

public interface manageOrder {
    public boolean delOrder(String ouid);
    public boolean pay(String payMethod,String ouid);
}
