package stick;

import org.utils.HttpUtil;

/**
 * Created by flysLi on 2018/1/9.
 */
public class Ticket {
    public static void main(String[] args) {
        String data = HttpUtil.get("https://kyfw.12306.cn/otn/leftTicket/queryZ?leftTicketDTO.train_date=2018-02-07&leftTicketDTO.from_station=SHH&leftTicketDTO.to_station=XCH&purpose_codes=ADULT");
        System.out.println(data);
    }
}
