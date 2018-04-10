package qq;

/**
 * @author flysLi
 * @date 2018/3/22
 */
public class GenerateKey {
    public static void main(String[] args) {
        String secretKey = "3weAVHxTnyyqW9f0AD5lGlCE71nOxNky";
        String srcStr = "Action=DescribeInstances&InstanceIds.0=ins-09dx96dg&Nonce=11886&Region=ap-guangzhou&SecretId=AKID8DLLAom8sTs6f9S8WkmdKpBQUP9hpKWc&SignatureMethod=HmacSHA256&Timestamp=" + System.currentTimeMillis();
        System.out.println(srcStr);
        srcStr = "GETcvm.api.qcloud.com/v2/index.php?" + srcStr;
        String signStr = Utils.HMACSHA256(srcStr.getBytes(), secretKey.getBytes());
        System.out.println(signStr);
    }
}
