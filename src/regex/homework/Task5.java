package regex.homework;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) throws InterruptedException {

        var emails = getEmails();

        String regex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        Pattern pattern = Pattern.compile(regex);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable runnable = () -> {
            for (String email : emails) {
                Matcher matcher = pattern.matcher(email);
                System.out.println(email + " : " + matcher.matches());
            }
        };

        long start = System.currentTimeMillis();
        executorService.submit(runnable);
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        long end = System.currentTimeMillis();

        System.out.println((end - start));

    }

    private static ArrayList<String> getEmails() {
        var emails = new ArrayList<String>();

        for (int i = 0; i < 2000; i++) {
            emailsFifty(emails);
        }

        return emails;
    }

    private static void emailsFifty(ArrayList<String> emails) {
        emails.add("TGm'Oww38gU7@uawbibaqx.edu");
        emails.add("BY1CoTf8J4mO@awqzxd.edu");
        emails.add("MX0I2Sn.PJau@fijhdvqc.biz");
        emails.add("7UgaAW7MAgD@bezadmdh.co.in");
        emails.add(".PNdY@ylfbwoe.info");
        emails.add("uQbTPdaE6Rw-PH@sseopwitll.info");
        emails.add("0D1oK@uau.net");
        emails.add("-5qcjBjm@jtysvtdg.org");
        emails.add("puAipIqWDHmva@jga.net");
        emails.add("eeHVnUJNXnCVpCL@ved.gov");
        emails.add("VluTCsH@jielwd.com");
        emails.add("QAMmZDS@umvpxjmc.co.in");
        emails.add("BdPCCq@hfhyuewkt.org");
        emails.add("u38aGq@tzkl.biz");
        emails.add("zC5tSlGrm1@lkejaegvot.com");
        emails.add("Ir8uWrt8JVpO@vcano.org");
        emails.add("5gUC'p'vm3uI@gvcjutxgk.net");
        emails.add("Rq_p.q@ehy.com");
        emails.add("OblkWMP@tuvdxkdz.com");
        emails.add("A.34-8njr@cfyaxdtf.gov");
        emails.add("Zr3qhbmtHxvQ5@iozb.org");
        emails.add("fud4T32X@drto.com");
        emails.add("GQghj@hlhrhljh.net");
        emails.add("-BwZb51f__@hxtvmqcou.co.in");
        emails.add("cC-kwherj@jxyta.co.in");
        emails.add("dpsjqaRHs-@enqsua.info");
        emails.add("ZiKJJLyt@brr.com");
        emails.add("WNgtUOv3YMYQn@xomjpb.com");
        emails.add("WOZ_H'NQTt@sbz.biz");
        emails.add("G7caZwqj7oK@jpf.info");
        emails.add("qxSXLlRHw@khodzj.org");
        emails.add("b17e5BfV9v.0i@akj.co.in");
        emails.add("x-x0Oc@pvdbiati.info");
        emails.add("KBcyR7@wmpmuoho.info");
        emails.add("dxjNrS9Z@sbfrxs.org");
        emails.add("VIrNRrulGv60M@wozifobe.org");
        emails.add("naN60k's93@plwbcxrrkm.info");
        emails.add("ytX9-II@pyrqeebef.com");
        emails.add("P2mYgYH5.iYIi@jllh.edu");
        emails.add("Az.lo7U1'@fsxafjr.info");
        emails.add("DFP8u34U@czhwziigu.com");
        emails.add("XG-ioQheelqMa@laagg.net");
        emails.add("m-hHIR'Q0Qu@kmqjmpss.org");
        emails.add("q4HeYht7ag@molwqwolq.org");
        emails.add("OTUgZaToKF4NLM@kdnoq.com");
        emails.add("6ydXHX@srcorolqvn.biz");
        emails.add("hKOBGr@omepbzgi.co.in");
        emails.add("n0iJwB@ldu.org");
        emails.add("1YezAc1@hncuemq.info");
        emails.add("lrLsIK443@gsghqmej.edu");
        emails.add("'8OC3i3@nfzod.info");
        emails.add("G8_FtmUwnv81MyH@aobrtkejii.net");
        emails.add("L9sHi0lPHV9@oveaujuqv.gov");
        emails.add("ci3y6zI5q@qnw.com");
        emails.add("D2S'jo4F4cd@tvra.com");
        emails.add("e3lnyA31pQFjY2D@mxpqw.net");
        emails.add("XA0rk5@xvddsvdf.info");
        emails.add("hiYf7QuAz1Nxp@pemxw.org");
        emails.add("iunq4M@fvl.org");
        emails.add("oFfGddba@ovx.org");
    }
}
