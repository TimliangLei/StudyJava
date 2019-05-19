package com.inspur;

import java.util.Arrays;

/**
 * 数据范围1-100
 * 主键范围0-9
 * key = data%key.length
 * 桶原理
 * 求桶最深的key=?深度为多少?
 */

public class App
{
    public static void main( String[] args )
    {
        int keyLength = 5;
        int boundNum = 38;
        int[] count = new int[keyLength];
        Node[] table = new Node[keyLength];
        for (int i = 0; i < table.length; i++){
            table[i] = new Node();
        }
        for (int num = 1; num <= boundNum; num++){
            int index = num % keyLength;
            count[index]++;
            Node temp = table[index];
            while (temp.getNext()!=null){
                temp = temp.getNext();
            }
            Node node = new Node(index,num);
            temp.setNext(node);
        }
        System.out.println(Arrays.toString(count));
        int maxLength = 0;
        for (int i = 0; i < keyLength; i++){
            int c = count[i];
            if (c > maxLength){
                maxLength = c;
            }
        }
        for (int i = 0; i < keyLength; i++){
            if (maxLength == count[i]){
                System.out.print("key="+i+" length="+maxLength+" values:");
                Node n = table[i];
                while (n.getNext()!=null){
                    if (n.getValue() != -1){
                        System.out.print(n.getValue()+" ");
                    }

                    n = n.getNext();
                }
                System.out.println();
            }
        }


    }
}
