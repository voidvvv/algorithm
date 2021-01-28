package cn.zkj.lk;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int[] arr = {2,1,4,7,3,2,5};
        int a= longestMountain(arr);
    }

    public static String getSend(String urls){
        HttpURLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL(urls);
            //得到连接对象
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent","bilibili Security Browser");
            //设置请求类型
            con.setRequestMethod("GET");
            con.setRequestProperty("Cookie","session=eyJ1aWQiOiIyMTYwMTk3MCJ9.X5RD3Q.vDv5NzhKFQi8Q2h1eJziJbgrcl0; role=7b7bc2512ee1fedcd76bdc68926d4f7b");
            //设置请求需要返回的数据类型和字符集类型
            con.setRequestProperty("Content-Type", "application/json;charset=GBK");



            //允许写出
            con.setDoOutput(true);
            //允许读入
            con.setDoInput(true);
            //不使用缓存
            con.setUseCaches(false);
//            OutputStream outputStream = con.getOutputStream();
//            Map<String,Object> params = new JSONObject();
//            params.put("username","Administrator");
//            params.put("passwd","bilibili");
//            String s = JSONObject.toJSONString(params);
//            outputStream.write(s.getBytes("UTF-8"));
            //得到响应码
            int responseCode = con.getResponseCode();
            Map<String, List<String>> headerFields = con.getHeaderFields();
//            JSONObject content = (JSONObject)con.getContent();
//            System.out.println(content);
            System.out.println(headerFields);
            String responseMessage = con.getResponseMessage();
            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = (InputStream)con.getContent();
                //将响应流转换成字符串
                resultBuffer = new StringBuffer();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while ((line = buffer.readLine()) != null) {
                    resultBuffer.append(line);
                }
                return resultBuffer.toString();
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String v(){
        HttpURLConnection con = null;

        BufferedReader buffer = null;
        StringBuffer resultBuffer = null;

        try {
            URL url = new URL("http://45.113.201.36/api/ctf/5?uid=100336889");
            //得到连接对象
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent","bilibili Security Browser");
            //设置请求类型
            con.setRequestMethod("GET");
            con.setRequestProperty("Cookie","session=eyJ1aWQiOiIyMTYwMTk3MCJ9.X5RD3Q.vDv5NzhKFQi8Q2h1eJziJbgrcl0; role=7b7bc2512ee1fedcd76bdc68926d4f7b");
            //设置请求需要返回的数据类型和字符集类型
            con.setRequestProperty("Content-Type", "application/json;charset=GBK");



            //允许写出
            con.setDoOutput(true);
            //允许读入
            con.setDoInput(true);
            //不使用缓存
            con.setUseCaches(false);
//            OutputStream outputStream = con.getOutputStream();
//            Map<String,Object> params = new JSONObject();
//            params.put("username","Administrator");
//            params.put("passwd","bilibili");
//            String s = JSONObject.toJSONString(params);
//            outputStream.write(s.getBytes("UTF-8"));
            //得到响应码
            int responseCode = con.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                //得到响应流
                InputStream inputStream = con.getInputStream();
                //将响应流转换成字符串
                resultBuffer = new StringBuffer();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while ((line = buffer.readLine()) != null) {
                    resultBuffer.append(line);
                }
                return resultBuffer.toString();
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void tt(Demo1 d){
        d = null;
    }

    /**
     * 24. 两两交换链表中的节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode next = head.next;
        if (head.next==null){
            return head;
        }

        ListNode next1 = next.next;


        next.next = head;
        head.next = next1;
        if (next1==null){
            return head;
        }
        swapPairs(next1);
        return next;

    }

    /**
     * 844. 比较含退格的字符串
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     * 注意：如果对空文本输入退格字符，文本继续为空。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @description: 思路：使用栈
     * @author: Mr.Z
     * @Date: 2020/10/19
       * @param S
     * @param T
     * @return: boolean
     * @version : 01
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sstack = new Stack<>();
        Stack<Character> tstack = new Stack<>();

        char[] schars = S.toCharArray();
        char[] tchars = T.toCharArray();

        int count = 0;
        while (true){
            if (count>=schars.length&&count>=tchars.length){
                break;
            }
            if (count<schars.length){
                char schar = schars[count];
                if (schar == '#'){
                    if (sstack.size()>0){
                        sstack.pop();
                    }

                }else {
                    sstack.push(schar);
                }

            }

            if (count<tchars.length){
                char tchar = tchars[count];
                if (tchar == '#'){
                    if (tstack.size()>0){
                        tstack.pop();
                    }

                }else {
                    tstack.push(tchar);
                }

            }
            count++;
        }


        return sstack.equals(tstack);

    }

    public void reorderList(ListNode head) {
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            queue.addLast(cur);
            cur = cur.next;
        }
        while (!queue.isEmpty()) {
            if (cur == null) {
                cur = queue.pollFirst();
            } else {
                cur.next = queue.pollFirst();
                cur = cur.next;
            }
            cur.next = queue.pollLast();
            cur = cur.next;
        }
        if (cur != null) {
            cur.next = null;
        }
    }

    /**
     * 925. 长按键入
     * @description:
     * @author: Mr.Z
     * @Date: 2020/10/21
       * @param name
     * @param typed
     * @return: boolean
     * @version : 01
     */
    public boolean isLongPressedName(String name, String typed) {
        byte[] nameBytes = name.getBytes();
        byte[] typedBytes = typed.getBytes();
        int typeCharIndex = 0;
        for(int x=0;x<nameBytes.length;){
            byte nameByte = nameBytes[x];
            int countNameChars = 1;
            x++;
            while (x<nameBytes.length&&nameBytes[x]==nameByte){
                x++;
                countNameChars++;
            }

            int countTypeChars = 0;
            while (typeCharIndex<typedBytes.length&&typedBytes[typeCharIndex]==nameByte){
                countTypeChars++;
                typeCharIndex++;
            }

            if (countNameChars>countTypeChars){
                return false;
            }

        }

        if (typeCharIndex<typedBytes.length){
            return false;
        }
        return true;
    }

    /**
     * 1024. 视频拼接
     * @description:
     * @author: Mr.Z
     * @Date: 2020/10/24
       * @param clips l
     * @param T l
     * @return: int
     * @version : 01
     */
    public int videoStitching(int[][] clips, int T) {
        return 0;
    }


    /**
     * 845. 数组中的最长山脉
     * @description:
     * @author: Mr.Z
     * @Date: 2020/10/25
       * @param A
     * @return: int
     * @version : 01
     */
    public static int longestMountain(int[] A) {
        int[] arr  =new int[2];
        if (A.length<3){
            return 0;
        }
        int result = 0;
        for (int x=1;x<A.length;){
            while (x<A.length&&A[x-1]<A[x]){
                arr[0]++;
                x++;
            }

            while (x<A.length&&A[x-1]>A[x]){
                if (arr[0]!=0){
                    arr[1]++;
                }
                x++;
            }

            result = Math.max(result,arr[0]+arr[1]);
            arr[0]=0;
            arr[1]=0;
        }
        if(result>=2){
            result++;
        }
        return result;
    }

    /**
     * 面试题 08.09. 括号
     * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
     *
     * 说明：解集不能包含重复的子集。
     * @description:
     * @author: Mr.Z
     * @Date: 2020/11/1
       * @param n
     * @return: java.util.List<java.lang.String>
     * @version : 01
     */
    public List<String> generateParenthesis(int n) {
        List<String> re = new ArrayList<>();

        if (n==1){
            re.add("()");
            return re;
        }

        return null;

    }

    /**
     * 349. 两个数组的交集
     * @description:
     * @author: Mr.Z
     * @Date: 2020/11/2
       * @param nums1
     * @param nums2
     * @return: int[]
     * @version : 01
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for (int x=0;x<nums1.length;x++){
            map1.put(nums1[x],map1.getOrDefault(nums1[x],0)+1);
        }

        for (int x=0;x<nums2.length;x++){
            if (map1.containsKey(nums2[x])){
                map2.put(nums2[x],Math.min(map1.get(nums2[x]),map2.getOrDefault(nums2[x],0)+1));
            }

        }

        List<Integer> re = new ArrayList<Integer>();
        Set<Integer> integers = map2.keySet();
        for (Integer s:integers){
            for (int x=0;x<map2.get(s);x++){
                re.add(s);
            }

        }

        int[] result = new int[re.size()];

        for (int x=0;x<re.size();x++){
            result[x] = re.get(x);
        }
        return result;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        for (int x=0;x<nums1.length;x++){
            map1.put(nums1[x],map1.getOrDefault(nums1[x],0)+1);
        }

        for (int x=0;x<nums2.length;x++){
            if (map1.containsKey(nums2[x])){
                map2.put(nums2[x],Math.min(map1.get(nums2[x]),map2.getOrDefault(nums2[x],0)+1));
            }

        }

        List<Integer> re = new ArrayList<Integer>();
        Set<Integer> integers = map2.keySet();
        for (Integer s:integers){
            for (int x=0;x<map2.get(s);x++){
                re.add(s);
            }

        }

        int[] result = new int[re.size()];

        for (int x=0;x<re.size();x++){
            result[x] = re.get(x);
        }
        return result;
    }

    /**
     * 941. 有效的山脉数组
     * @description:
     * @author: Mr.Z
     * @Date: 2020/11/3
       * @param A
     * @return: boolean
     * @version : 01
     */
    public boolean validMountainArray(int[] A) {
        if (A.length<3){
            return false;
        }
        int ind = 0;
        for(int x=1;x<A.length;x++){
            if (A[x-1]<A[x]){

            }else if (A[x-1]==A[x]){
                return false;
            }else {
                ind = x;
                break;
            }
        }

        for(int x=ind;x<A.length;x++){
            if (A[x-1]>A[x]){

            }else if (A[x-1]==A[x]){
                return false;
            }else {
                return false;
            }
        }
        return true;

    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。设计一个算法来计算你所能获取的最大利润。
     * @description:
     * @author: Mr.Z
     * @Date: 2020/11/8
       * @param prices
     * @return: int
     * @version : 01
     */
    public int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int re=0;
        for (int x=1;x<prices.length;x++){

            if (prices[x-1]<prices[x]){
                re+=(prices[x]-prices[x-1]);
            }

        }

        return re;
    }

    /**
     * 31. 下一个排列
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @description:
     * @author: Mr.Z
     * @Date: 2020/11/10
       * @param nums
     * @return: void
     * @version : 01
     */
    public void nextPermutation(int[] nums) {
        if (nums==null){
            return;
        }
        if (nums.length<=1){
            return;
        }
        int minIndex = -1;
        int minNum = nums[nums.length-1];
        int lIndex=0;
        for (int x=nums.length-2;x>=0; System.out.println("asd")){
            for (int y = nums.length-1;y>x;y--){
                if (nums[y]>nums[x]){
                    if (minNum<=0){}


                }

            }
        }
        if (minIndex<0){
            int bound = nums.length-1;
            for (int x=0;x<nums.length/2;x++){
                int temp = nums[x];
                nums[x] = nums[bound-x];
                nums[bound] = temp;

            }
            return;
        }

    }

    /**
     * @description: 1122. 数组的相对排序
     * @author: Mr.Z
     * @Date: 2020/11/14
       * @param arr1
     * @param arr2
     * @return: int[]
     * @version : 01
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int numCount = 0;
        for (int y=0;y<arr2.length;y++){
            for (int x=0;x<arr1.length;x++){
                if (arr1[x]==arr2[y]){
                    int temp = arr1[x];
                    arr1[x] = arr1[numCount];
                    arr1[numCount] = temp;
                    numCount++;

                }
            }
        }
        Arrays.sort(arr1,numCount+1,arr1.length);
        return arr1;
    }

    /**
     * 283. 移动零
     * @description: 283. 移动零
     * @author: Mr.Z
     * @Date: 2020/11/19
       * @param nums
     * @return: void
     * @version : 01
     */
    public void moveZeroes(int[] nums) {
        //拷贝额外数组
        //***********************
//        int[] temp = new int[nums.length];
//        int count = 0;
//        for (int x=0;x<temp.length;x++){
//            int num = nums[x];
//            if (num!=0){
//                temp[count++] = num;
//            }
//        }
        //*********************************
        int len = 0;

        for (int x=0;x<nums.length;x++){
            if (nums[x]!=0){
                nums[len++] = nums[x];
            }
        }
        for (int x=len;x<nums.length;x++){
            nums[x]=0;
        }
    }

    /**
     * 147. 对链表进行插入排序
     * @description:
     * @author: Mr.Z
     * @Date: 2020/11/20
       * @param head
     * @return: cn.zkj.lk.ListNode
     * @version : 01
     */
    public ListNode insertionSortList(ListNode head) {

        if(head==null||head.next==null){
            return head;
        }

        ListNode temp = head.next;
        ListNode preTemp = head;
        while (temp!=null){
            ListNode index = head;
            while (index!=null){
                if (temp.val>index.val||index==temp){
                    ListNode indesxNext = index.next;
                    ListNode tempNext = temp.next;

                    index.next =temp;
                    temp.next=indesxNext;
                    preTemp.next = tempNext;
                    temp = tempNext;

                }else {
                    index = index.next;
                }

            }

        }
        return null;
    }

    /**
     * 205. 同构字符串
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/isomorphic-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @description:
     * @author: Mr.Z
     * @Date: 2020/12/27
       * @param s
     * @param t
     * @return: boolean
     * @version : 01
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> kvMap = new HashMap<>();

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int length = s.length();

        for (int x=0;x<length;x++){
            char sChar = sChars[x];
            char tChar = tChars[x];
            if (kvMap.get(sChar)==null){
                if (sChar == tChar){

                }else {
                    kvMap.put(sChar,tChar);
                }
            }else {
                Character character = kvMap.get(sChar);
                if (character.equals(tChar)){

                }else {
                    return false;
                }

            }


        }
        return true;
    }

    private Character getKeyV(Map<Character,Character> kvMap,Character key){
        if (kvMap.get(key)==null){
            return key;
        }
        return kvMap.get(key);

    }

    /**
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        for (int x=0;x<k;x++){
            int end = nums[nums.length-1];
            for (int m=nums.length-1;m>=0;m--){
                if (m==0){
                    nums[m] = end;
                }else {
                    nums[m] = nums[m-1];
                }
            }
        }
    }
}
