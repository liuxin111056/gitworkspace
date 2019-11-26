

import com.alibaba.fastjson.JSON;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * ???http??????
 *
 * @author xr
 *
 */
public class testGet {

    public static String getJsonData(String jsonParam, String urls) {
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(urls);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            byte[] data = (jsonParam.toString()).getBytes();
            conn.setRequestProperty("Content-Length", String.valueOf(data.length));
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("accept", "application/json");
            conn.connect();
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            out.write((jsonParam.toString()).getBytes());
            out.flush();
            out.close();
            System.out.println(conn.getResponseCode());
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                InputStream in1 = conn.getInputStream();
                try {
                    String readLine = new String();
                    BufferedReader responseReader = new BufferedReader(new InputStreamReader(in1, "UTF-8"));
                    while ((readLine = responseReader.readLine()) != null) {
                        sb.append(readLine).append("\n");
                    }
                    responseReader.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String url = "http://192.168.1.204:8080/api/resservice/engineAntiFraud";
        String data = "{\n" +
                "  \"engineCode\": \"WHYC001\",\n" +
                "  \"org\": \"001\",\n" +
                "  \"appNo\": \"20191121120000000029\",\n" +
                "  \"params\": {\n" +
                "    \"tmAppAttachInfoMap\": {},\n" +
                "    \"tmAppCardFaceInfoMap\": {},\n" +
                "    \"tmAppContactInfoMap\": {},\n" +
                "    \"tmAppExtendMap\": {\n" +
                "      \"attatchTabs1\": {\n" +
                "        \"appNo\": \"20191121120000000029\",\n" +
                "        \"attachNo\": 1,\n" +
                "        \"createDate\": 1574310801000,\n" +
                "        \"id\": 14,\n" +
                "        \"jpaVersion\": 0,\n" +
                "        \"obDate1\": 1574310755000,\n" +
                "        \"obDate2\": 1574310755000,\n" +
                "        \"obDate3\": 1574310755000,\n" +
                "        \"obDate4\": 1574310755000,\n" +
                "        \"org\": \"000064540000\",\n" +
                "        \"updateDate\": 1574310801000,\n" +
                "        \"updateUser\": \"Approver01\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"tmAppHistoryList\": [\n" +
                "      {\n" +
                "        \"appNo\": \"20191121120000000029\",\n" +
                "        \"createDate\": 1574310801000,\n" +
                "        \"id\": 107,\n" +
                "        \"idNo\": \"370102199003078974\",\n" +
                "        \"idType\": \"I\",\n" +
                "        \"jpaVersion\": 0,\n" +
                "        \"name\": \"对对对\",\n" +
                "        \"obDate1\": 1574310755000,\n" +
                "        \"obDate2\": 1574310755000,\n" +
                "        \"operatorId\": \"Approver01\",\n" +
                "        \"org\": \"000064540000\",\n" +
                "        \"proName\": \"申请录入\",\n" +
                "        \"proNum\": \"20191121120000000029\",\n" +
                "        \"rtfState\": \"A10\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appNo\": \"20191121120000000029\",\n" +
                "        \"createDate\": 1574310854000,\n" +
                "        \"id\": 108,\n" +
                "        \"idNo\": \"370102199003078974\",\n" +
                "        \"idType\": \"I\",\n" +
                "        \"jpaVersion\": 0,\n" +
                "        \"name\": \"对对对\",\n" +
                "        \"obDate1\": 1574310808000,\n" +
                "        \"obDate2\": 1574310808000,\n" +
                "        \"operatorId\": \"Approver01\",\n" +
                "        \"org\": \"000064540000\",\n" +
                "        \"proName\": \"录入复核\",\n" +
                "        \"proNum\": \"20191121120000000029\",\n" +
                "        \"remark\": \"\",\n" +
                "        \"rtfState\": \"B10\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appNo\": \"20191121120000000029\",\n" +
                "        \"createDate\": 1574310855000,\n" +
                "        \"id\": 109,\n" +
                "        \"idNo\": \"370102199003078974\",\n" +
                "        \"idType\": \"I\",\n" +
                "        \"jpaVersion\": 0,\n" +
                "        \"name\": \"对对对\",\n" +
                "        \"obDate1\": 1574310809000,\n" +
                "        \"obDate2\": 1574310809000,\n" +
                "        \"operatorId\": \"sysauto\",\n" +
                "        \"org\": \"000064540000\",\n" +
                "        \"proName\": \"申请完整性验证\",\n" +
                "        \"proNum\": \"20191121120000000029\",\n" +
                "        \"rtfState\": \"C05\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"appNo\": \"20191121120000000029\",\n" +
                "        \"createDate\": 1574310856000,\n" +
                "        \"id\": 110,\n" +
                "        \"idNo\": \"370102199003078974\",\n" +
                "        \"idType\": \"I\",\n" +
                "        \"jpaVersion\": 0,\n" +
                "        \"name\": \"对对对\",\n" +
                "        \"obDate1\": 1574310810000,\n" +
                "        \"obDate2\": 1574310810000,\n" +
                "        \"operatorId\": \"sysauto\",\n" +
                "        \"org\": \"000064540000\",\n" +
                "        \"proName\": \"申请有效性检查\",\n" +
                "        \"proNum\": \"20191121120000000029\",\n" +
                "        \"rtfState\": \"D05\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"tmAppMain\": {\n" +
                "      \"appLmt\": 10000,\n" +
                "      \"appNo\": \"20191121120000000029\",\n" +
                "      \"appType\": \"B\",\n" +
                "      \"approveQuickFlag\": \"N\",\n" +
                "      \"assignee\": \"Approver01\",\n" +
                "      \"cellphone\": \"16602125061\",\n" +
                "      \"createDate\": 1574310788000,\n" +
                "      \"createUser\": \"Approver01\",\n" +
                "      \"custType\": \"A00\",\n" +
                "      \"id\": 29,\n" +
                "      \"idNo\": \"411221\",\n" +
                "      \"idType\": \"I\",\n" +
                "      \"isClt\": \"N\",\n" +
                "      \"age\": 20,\n" +
                "      \"year\": 120,\n" +
                "      \"isInstalment\": \"N\",\n" +
                "      \"isOldCust\": \"N\",\n" +
                "      \"isPriority\": \"N\",\n" +
                "      \"isUrgentCard\": \"N\",\n" +
                "      \"xueli\": 5,\n" +
                "      \"lastOpUser\": \"Approver01\",\n" +
                "      \"name\": \"对对对\",\n" +
                "      \"obDate1\": 1574310755000,\n" +
                "      \"obDate2\": 1574310755000,\n" +
                "      \"org\": \"000064540000\",\n" +
                "      \"otherBankTotalLmt\": 10000.00,\n" +
                "      \"owner\": \"Approver01\",\n" +
                "      \"productCd\": \"000001\",\n" +
                "      \"realtimeIssuingFlag\": \"N\",\n" +
                "      \"remark\": \"\",\n" +
                "      \"rtfState\": \"D05\",\n" +
                "      \"taskDefKey\": \"applyinfo-review\",\n" +
                "      \"taskId\": \"1197372404539260928\",\n" +
                "      \"taskName\": \"录入复核\",\n" +
                "      \"updateDate\": 1574310856000,\n" +
                "      \"updateUser\": \"Approver01\"\n" +
                "    },\n" +
                "    \"tmAppMemoMapAll\": {\n" +
                "      \"REMARK-REVIEW\": [\n" +
                "        {\n" +
                "          \"appNo\": \"20191121120000000029\",\n" +
                "          \"createDate\": 1574310851000,\n" +
                "          \"createUser\": \"Approver01\",\n" +
                "          \"id\": 49,\n" +
                "          \"jpaVersion\": 0,\n" +
                "          \"memoType\": \"REMARK\",\n" +
                "          \"memoVersion\": 1,\n" +
                "          \"org\": \"000064540000\",\n" +
                "          \"rtfState\": \"B05\",\n" +
                "          \"taskDesc\": \"applyinfo-review\",\n" +
                "          \"taskKey\": \"REVIEW\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"MEMO-INPUT\": [\n" +
                "        {\n" +
                "          \"appNo\": \"20191121120000000029\",\n" +
                "          \"createDate\": 1574310801000,\n" +
                "          \"createUser\": \"Approver01\",\n" +
                "          \"id\": 47,\n" +
                "          \"jpaVersion\": 0,\n" +
                "          \"memoType\": \"MEMO\",\n" +
                "          \"memoVersion\": 1,\n" +
                "          \"org\": \"000064540000\",\n" +
                "          \"rtfState\": \"A10\",\n" +
                "          \"taskDesc\": \"applyinfo-input\",\n" +
                "          \"taskKey\": \"INPUT\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"REMARK-INPUT\": [\n" +
                "        {\n" +
                "          \"appNo\": \"20191121120000000029\",\n" +
                "          \"createDate\": 1574310801000,\n" +
                "          \"createUser\": \"Approver01\",\n" +
                "          \"id\": 48,\n" +
                "          \"jpaVersion\": 0,\n" +
                "          \"memoType\": \"REMARK\",\n" +
                "          \"memoVersion\": 1,\n" +
                "          \"org\": \"000064540000\",\n" +
                "          \"rtfState\": \"A10\",\n" +
                "          \"taskDesc\": \"applyinfo-input\",\n" +
                "          \"taskKey\": \"INPUT\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    \"tmAppMemoMapLast\": {\n" +
                "      \"MEMO_INPUT\": {\n" +
                "        \"$ref\": \"$.inFields.tmAppMemoMapAll.MEMO-INPUT[0]\"\n" +
                "      },\n" +
                "      \"REMARK_INPUT\": {\n" +
                "        \"$ref\": \"$.inFields.tmAppMemoMapAll.REMARK-INPUT[0]\"\n" +
                "      },\n" +
                "      \"REMARK_REVIEW\": {\n" +
                "        \"$ref\": \"$.inFields.tmAppMemoMapAll.REMARK-REVIEW[0]\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"tmAppNodeInfoRecordMap\": {\n" +
                "      \"applyNodeReviewData\": {\n" +
                "        \"reviewsMap\": {\n" +
                "          \"commonTab\": {\n" +
                "            \"tmAppMain.name\": \"对对对\"\n" +
                "          }\n" +
                "        }\n" +
                "      },\n" +
                "      \"applyNodeCommonData\": {\n" +
                "        \"appNo\": \"20191121120000000029\",\n" +
                "        \"appType\": \"B\",\n" +
                "        \"approveQuickFlag\": \"N\",\n" +
                "        \"date\": 1574310853637,\n" +
                "        \"idNo\": \"370102199003078974\",\n" +
                "        \"idType\": \"I\",\n" +
                "        \"isRefuse\": \"N\",\n" +
                "        \"name\": \"对对对\",\n" +
                "        \"operatorId\": \"Approver01\",\n" +
                "        \"org\": \"000064540000\",\n" +
                "        \"productCd\": \"000001\",\n" +
                "        \"rtfStateType\": \"B10\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"tmAppPrimAnnexEvi\": {\n" +
                "      \"appNo\": \"20191121120000000029\",\n" +
                "      \"createDate\": 1574310801000,\n" +
                "      \"financeBuyDate\": 1574310755000,\n" +
                "      \"fundDepositeDate\": 1574310755000,\n" +
                "      \"id\": 14,\n" +
                "      \"jpaVersion\": 0,\n" +
                "      \"obDate1\": 1574310755000,\n" +
                "      \"obDate2\": 1574310755000,\n" +
                "      \"org\": \"000064540000\",\n" +
                "      \"updateDate\": 1574310801000,\n" +
                "      \"updateUser\": \"Approver01\"\n" +
                "    },\n" +
                "    \"tmAppPrimApplicantInfo\": {\n" +
                "      \"age\": \"29\",\n" +
                "      \"appNo\": \"20191121120000000029\",\n" +
                "      \"bankmemFlag\": \"N\",\n" +
                "      \"birthday\": 636739200000,\n" +
                "      \"cellphone\": \"16602125061\",\n" +
                "      \"createDate\": 1574310788000,\n" +
                "      \"embLogo\": \"DUI DUIDUI\",\n" +
                "      \"empCity\": \"南昌市\",\n" +
                "      \"empProvince\": \"江西省\",\n" +
                "      \"empStability\": \"B\",\n" +
                "      \"gender\": \"M\",\n" +
                "      \"homeCity\": \"南昌市\",\n" +
                "      \"homeState\": \"江西省\",\n" +
                "      \"id\": 35,\n" +
                "      \"idLastAll\": \"N\",\n" +
                "      \"idNo\": \"370102199003078974\",\n" +
                "      \"idType\": \"I\",\n" +
                "      \"ifSelectedCard\": \"N\",\n" +
                "      \"jpaVersion\": 0,\n" +
                "      \"name\": \"对对对\",\n" +
                "      \"obDate1\": 1574310755000,\n" +
                "      \"obDate2\": 1574310755000,\n" +
                "      \"org\": \"000064540000\",\n" +
                "      \"photoUseFlag\": \"N\",\n" +
                "      \"posPinVerifyInd\": \"Y\",\n" +
                "      \"prOfCountry\": \"Y\",\n" +
                "      \"smAmtVerifyInd\": \"Y\",\n" +
                "      \"updateDate\": 1574310801000,\n" +
                "      \"updateUser\": \"Approver01\"\n" +
                "    },\n" +
                "    \"tmAppPrimCardInfo\": {\n" +
                "      \"appNo\": \"20191121120000000029\",\n" +
                "      \"cardFetchMethod\": \"A\",\n" +
                "      \"createDate\": 1574310805000,\n" +
                "      \"ddBankAcctNoType\": \"N\",\n" +
                "      \"ddInd\": \"C\",\n" +
                "      \"id\": 28,\n" +
                "      \"inputDate\": 1574310755000,\n" +
                "      \"isPrdChange\": \"Y\",\n" +
                "      \"isSalesInd\": \"Y\",\n" +
                "      \"jpaVersion\": 0,\n" +
                "      \"org\": \"000064540000\",\n" +
                "      \"reviewName\": \"Approver01\",\n" +
                "      \"reviewNo\": \"Approver01\",\n" +
                "      \"updateDate\": 1574310851000,\n" +
                "      \"updateUser\": \"Approver01\"\n" +
                "    },\n" +
                "    \"tmEtcCar\": {\n" +
                "      \"appNo\": \"20191121120000000029\",\n" +
                "      \"id\": 14,\n" +
                "      \"jpaVersion\": 0,\n" +
                "      \"org\": \"000064540000\",\n" +
                "      \"updateDate\": 1574310801000,\n" +
                "      \"updateUser\": \"Approver01\"\n" +
                "    }\n" +
                "  }\n" +
                "}\n";
        String data01  = getJsonData(data, url);
        String data02 = StringEscapeUtils.unescapeJava(data01);
        String data03=data02.substring(1);
        String data04=data03.substring(0,data03.length()-2);
        Map map = JSON.parseObject(data04, Map.class);
        System.out.println(data04);
        System.out.println(map.get("outputFieldInfo"));
		/*String data01 = StringEscapeUtils.unescapeJava(resp);
		System.out.println(data01);
		Map map = JSON.parseObject(data01, Map.class);

		System.out.println(map);*/

        String author = JsonPath.read(data04, "$.outputFields[0].value");
        System.out.println(author);


    }

}
